/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.objectlock;

import com.obs.services.model.BaseBucketRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 获取桶级默认WORM策略请求
 */
public class GetObjectLockConfigurationRequest extends BaseBucketRequest {
    {
        httpMethod = HttpMethodEnum.GET;
    }

    public GetObjectLockConfigurationRequest() {
    }

    public GetObjectLockConfigurationRequest(String bucketName) {
        super(bucketName);
    }
}
