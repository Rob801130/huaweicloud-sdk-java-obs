package com.obs.services;

import com.obs.services.internal.task.DownloadFileTask;
import com.obs.services.internal.task.UploadFileTask;
import com.obs.services.model.CompleteMultipartUploadResult;
import com.obs.services.model.DownloadFileRequest;
import com.obs.services.model.DownloadFileResult;
import com.obs.services.model.TaskCallback;
import com.obs.services.model.UploadFileRequest;

public interface IObsClientAsync {
    UploadFileTask uploadFileAsync(
            UploadFileRequest uploadFileRequest,
            TaskCallback<CompleteMultipartUploadResult, UploadFileRequest> completeCallback);

    DownloadFileTask downloadFileAsync(
            DownloadFileRequest downloadFileRequest,
            TaskCallback<DownloadFileResult, DownloadFileRequest> completeCallback);
}
