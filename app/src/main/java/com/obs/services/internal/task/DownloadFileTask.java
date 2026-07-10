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

package com.obs.services.internal.task;

import static com.obs.services.internal.utils.ServiceUtils.changeFromThrowable;

import com.obs.log.ILogger;
import com.obs.log.LoggerBuilder;
import com.obs.services.AbstractClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.DownloadFileRequest;
import com.obs.services.model.DownloadFileResult;
import com.obs.services.model.TaskCallback;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class DownloadFileTask implements Callable<Object> {
    private final AbstractClient obsClient;
    private final String bucketName;
    private DownloadFileRequest taskRequest;
    private TaskCallback<DownloadFileResult, DownloadFileRequest> completeCallback;

    private Future<?> resultFuture;

    private static final ILogger log = LoggerBuilder.getLogger(DownloadFileTask.class);

    public DownloadFileTask(
            AbstractClient obsClient,
            String bucketName,
            DownloadFileRequest taskRequest,
            TaskCallback<DownloadFileResult, DownloadFileRequest> completeCallback) {
        this.obsClient = obsClient;
        this.bucketName = bucketName;
        this.taskRequest = taskRequest;
        this.completeCallback = completeCallback;
    }

    public AbstractClient getObsClient() {
        return obsClient;
    }

    public String getBucketName() {
        return bucketName;
    }

    public Optional<DownloadFileResult> getResult() {
        try {
            Object result = resultFuture.get();
            if (result instanceof DownloadFileResult) {
                return Optional.of((DownloadFileResult) result);
            } else {
                String errorMsg = "DownloadFileTask Error, result is " +
                        (result != null ? "not instance of DownloadFileResult!" : "null");
                errorMsg += isTaskCancelled() ? ", downloadFileRequest is canceled." : "";
                log.error(errorMsg);
                return Optional.empty();
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error("DownloadFileTask Error:" , e);
            return Optional.empty();
        }
    }

    public void setResultFuture(Future<?> future) {
        resultFuture = future;
    }

    public boolean cancel() {
        if (taskRequest.getCancelHandler() != null) {
            taskRequest.getCancelHandler().cancel();
            return true;
        } else {
            String errorInfo = "DownloadFileTask Cancel Error: CancelHandler is null, can not cancel!";
            log.error(errorInfo);
            return false;
        }
    }

    public boolean pause() {
        if (taskRequest.getTransferHandle() != null) {
            taskRequest.getTransferHandle().pause();
            return true;
        }
        log.error("DownloadFileTask Pause Error: transferHandle is null, can not pause!");
        return false;
    }

    private boolean isTaskCancelled() {
        return taskRequest.getCancelHandler() != null && taskRequest.getCancelHandler().isCancelled();
    }

    protected DownloadFileResult downloadFileWithCallBack() {
        try {
            DownloadFileResult downloadFileResult = obsClient.downloadFile(taskRequest);
            completeCallback.onSuccess(downloadFileResult);
            return downloadFileResult;
        } catch (ObsException e) {
            completeCallback.onException(e, taskRequest);
        } catch (Throwable t) {
            completeCallback.onException(changeFromThrowable(t), taskRequest);
        }
        return null;
    }

    public boolean isTaskFinished() {
        return resultFuture.isDone();
    }

    public void waitUntilFinished() {
        try {
            resultFuture.get();
        } catch (Throwable t) {
            log.warn("DownloadFileTask waitUntilFinished Error:", t);
        }
    }

    @Override
    public Object call() throws Exception {
        return downloadFileWithCallBack();
    }
}
