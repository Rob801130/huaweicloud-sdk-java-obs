/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.compress;

import com.obs.services.model.BaseBucketRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 删除在线解压策略请求
 */
public class DeleteBucketCompressPolicyRequest extends BaseBucketRequest {
    {
        httpMethod = HttpMethodEnum.DELETE;
    }

    public DeleteBucketCompressPolicyRequest() {
    }

    public DeleteBucketCompressPolicyRequest(String bucketName) {
        super(bucketName);
    }
}