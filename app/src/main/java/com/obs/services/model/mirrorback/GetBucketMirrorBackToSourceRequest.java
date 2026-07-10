/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.obs.services.model.BaseBucketRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 获取镜像回源策略请求
 */
public class GetBucketMirrorBackToSourceRequest extends BaseBucketRequest {
    {
        httpMethod = HttpMethodEnum.GET;
    }

    public GetBucketMirrorBackToSourceRequest() {
    }

    public GetBucketMirrorBackToSourceRequest(String bucketName) {
        super(bucketName);
    }
}
