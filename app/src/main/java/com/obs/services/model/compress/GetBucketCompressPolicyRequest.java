/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.compress;

import com.obs.services.model.BaseBucketRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 获取在线解压策略请求
 */
public class GetBucketCompressPolicyRequest extends BaseBucketRequest {
    {
        httpMethod = HttpMethodEnum.GET;
    }

    public GetBucketCompressPolicyRequest() {
    }

    public GetBucketCompressPolicyRequest(String bucketName) {
        super(bucketName);
    }
}