/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.dis;

import com.obs.services.model.BaseBucketRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 设置DIS通知策略请求
 */
public class SetBucketDisPolicyRequest extends BaseBucketRequest {
    {
        httpMethod = HttpMethodEnum.PUT;
    }

    private DisPolicyConfiguration disPolicyConfiguration;

    public SetBucketDisPolicyRequest(String bucketName, DisPolicyConfiguration disPolicyConfiguration) {
        super(bucketName);
        this.disPolicyConfiguration = disPolicyConfiguration;
    }

    public DisPolicyConfiguration getDisPolicyConfiguration() {
        return disPolicyConfiguration;
    }

    public void setDisPolicyConfiguration(DisPolicyConfiguration disPolicyConfiguration) {
        this.disPolicyConfiguration = disPolicyConfiguration;
    }
}