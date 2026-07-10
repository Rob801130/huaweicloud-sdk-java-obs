/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.dis;

import com.obs.services.model.BaseBucketRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 删除DIS通知策略请求
 */
public class DeleteBucketDisPolicyRequest extends BaseBucketRequest {
    {
        httpMethod = HttpMethodEnum.DELETE;
    }

    public DeleteBucketDisPolicyRequest() {
    }

    public DeleteBucketDisPolicyRequest(String bucketName) {
        super(bucketName);
    }
}