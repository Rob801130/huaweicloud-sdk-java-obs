/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.dis;

import com.obs.services.model.BaseBucketRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 获取DIS通知策略请求
 */
public class GetBucketDisPolicyRequest extends BaseBucketRequest {
    {
        httpMethod = HttpMethodEnum.GET;
    }

    public GetBucketDisPolicyRequest() {
    }

    public GetBucketDisPolicyRequest(String bucketName) {
        super(bucketName);
    }
}