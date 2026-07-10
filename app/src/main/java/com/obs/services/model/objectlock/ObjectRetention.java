/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.objectlock;

/**
 * 对象级WORM保护策略配置
 *
 * @since 3.24.4
 */
public class ObjectRetention {
    private String mode;

    private Long retainUntilDate;

    public ObjectRetention() {
    }

    /**
     * Constructor
     *
     * @param mode
     *            保护模式，当前仅支持 COMPLIANCE
     * @param retainUntilDate
     *            保护期限时间戳（毫秒），必须晚于当前时间
     */
    public ObjectRetention(String mode, Long retainUntilDate) {
        this.mode = mode;
        this.retainUntilDate = retainUntilDate;
    }

    /**
     * 获取保护模式
     *
     * @return 保护模式
     */
    public String getMode() {
        return mode;
    }

    /**
     * 设置保护模式
     *
     * @param mode
     *            保护模式，当前仅支持 COMPLIANCE
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * 获取保护期限时间戳
     *
     * @return 保护期限时间戳（毫秒）
     */
    public Long getRetainUntilDate() {
        return retainUntilDate;
    }

    /**
     * 设置保护期限时间戳
     *
     * @param retainUntilDate
     *            保护期限时间戳（毫秒），必须晚于当前时间
     */
    public void setRetainUntilDate(Long retainUntilDate) {
        this.retainUntilDate = retainUntilDate;
    }

    @Override
    public String toString() {
        return "ObjectRetention [mode=" + mode + ", retainUntilDate=" + retainUntilDate + "]";
    }
}
