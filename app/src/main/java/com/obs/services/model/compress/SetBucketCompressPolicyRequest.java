/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.compress;

import com.obs.services.model.BaseBucketRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 设置在线解压策略请求
 */
public class SetBucketCompressPolicyRequest extends BaseBucketRequest {
    {
        httpMethod = HttpMethodEnum.PUT;
    }

    private CompressPolicyConfiguration compressPolicyConfiguration;

    public SetBucketCompressPolicyRequest(String bucketName, CompressPolicyConfiguration compressPolicyConfiguration) {
        super(bucketName);
        this.compressPolicyConfiguration = compressPolicyConfiguration;
    }

    public CompressPolicyConfiguration getCompressPolicyConfiguration() {
        return compressPolicyConfiguration;
    }

    public void setCompressPolicyConfiguration(CompressPolicyConfiguration compressPolicyConfiguration) {
        this.compressPolicyConfiguration = compressPolicyConfiguration;
    }
}