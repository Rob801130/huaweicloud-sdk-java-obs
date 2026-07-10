/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.obs.services.model.BaseBucketRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 删除镜像回源策略请求
 */
public class DeleteBucketMirrorBackToSourceRequest extends BaseBucketRequest {
    {
        httpMethod = HttpMethodEnum.DELETE;
    }

    public DeleteBucketMirrorBackToSourceRequest() {
    }

    public DeleteBucketMirrorBackToSourceRequest(String bucketName) {
        super(bucketName);
    }
}
