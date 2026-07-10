/**
 * Copyright 2019 Huawei Technologies Co.,Ltd.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.obs.services.model;

import com.obs.services.internal.utils.CallCancelHandler;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 统一的断点续传暂停/取消句柄，包装已有的 {@link CallCancelHandler}，
 * 提供暂停（graceful stop + save checkpoint）和取消（immediate abort）能力。
 *
 * <p>状态机：
 * <pre>
 *   ACTIVE ──pause()──→ PAUSED ──resume()──→ ACTIVE
 *     │                    │
 *     └──cancel()──→ CANCELLED ←──┘  (终态)
 * </pre>
 *
 * <p>非预期状态转换将抛出 {@link IllegalStateException}。
 *
 * <p>使用方式：
 * <pre>
 *   ResumableTransferHandle handle = new ResumableTransferHandle();
 *   uploadFileRequest.setTransferHandle(handle);
 *   // 异步场景：handle.pause() 暂停 / handle.cancel() 取消
 * </pre>
 */
public class ResumableTransferHandle {

    /**
     * 传输状态枚举。
     */
    private enum State {
        /** 正常运行中 */
        ACTIVE,
        /** 已暂停，可通过 resume() 恢复 */
        PAUSED,
        /** 已取消，终态，不可恢复 */
        CANCELLED
    }

    private CallCancelHandler cancelHandler;

    private final AtomicReference<State> state = new AtomicReference<>(State.ACTIVE);

    /**
     * 绑定到 request 上已有的 cancelHandler。由 ResumableClient 在执行时自动调用。
     * 若传入的 cancelHandler 为 null，则内部自动创建一个新实例。
     * 若从未调用此方法，内部会自动创建一个默认的 CallCancelHandler。
     *
     * @param cancelHandler request 上的取消处理器
     */
    public void bind(CallCancelHandler cancelHandler) {
        this.cancelHandler = cancelHandler != null ? cancelHandler : new CallCancelHandler();
    }

    private CallCancelHandler ensureCancelHandler() {
        if (cancelHandler == null) {
            cancelHandler = new CallCancelHandler();
        }
        return cancelHandler;
    }

    /**
     * 暂停传输：等待当前分片完成后停止提交新任务，并保存 checkpoint。
     * 仅在 ACTIVE 状态下可调用。
     *
     * <p>前提条件：需开启 enableCheckpoint，否则暂停效果等同于取消。
     *
     * @throws IllegalStateException 若当前状态不是 ACTIVE
     */
    public void pause() {
        if (!state.compareAndSet(State.ACTIVE, State.PAUSED)) {
            throw new IllegalStateException(
                    "Cannot pause: current state is " + state.get() + ", expected ACTIVE");
        }
    }

    /**
     * 取消传输：立即中断所有 HTTP Call。
     * 从 ACTIVE 或 PAUSED 状态均可调用；已取消时为幂等操作（无副作用）。
     *
     * @throws IllegalStateException 仅内部防御用，正常使用不会触发
     */
    public void cancel() {
        if (state.get() == State.CANCELLED) {
            return;
        }
        state.set(State.CANCELLED);
        ensureCancelHandler().cancel();
    }

    /**
     * 从暂停状态恢复传输：清除暂停标记和内部 CallCancelHandler 状态，
     * 使句柄回到 ACTIVE 状态，随后重新提交传输任务即可从断点继续。
     * 仅在 PAUSED 状态下可调用。
     *
     * @throws IllegalStateException 若当前状态不是 PAUSED
     */
    public void resume() {
        if (!state.compareAndSet(State.PAUSED, State.ACTIVE)) {
            throw new IllegalStateException(
                    "Cannot resume: current state is " + state.get() + ", expected PAUSED");
        }
        ensureCancelHandler().resetCancelStatus();
    }

    /**
     * 判断传输是否已被暂停。
     *
     * @return 是否已暂停
     */
    public boolean isPaused() {
        return state.get() == State.PAUSED;
    }

    /**
     * 判断传输是否已被取消。
     *
     * @return 是否已取消
     */
    public boolean isCancelled() {
        return state.get() == State.CANCELLED;
    }

    /**
     * 判断传输是否已被暂停或取消。
     *
     * @return 是否已暂停或取消
     */
    public boolean isPausedOrCancelled() {
        State current = state.get();
        return current == State.PAUSED || current == State.CANCELLED;
    }

    /**
     * 获取内部绑定的 CallCancelHandler。
     *
     * @return 绑定的取消处理器
     */
    public CallCancelHandler getCancelHandler() {
        return ensureCancelHandler();
    }
}