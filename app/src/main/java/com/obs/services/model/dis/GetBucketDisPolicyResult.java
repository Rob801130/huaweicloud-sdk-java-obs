/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.dis;

import com.obs.services.model.HeaderResponse;

/**
 * 获取DIS通知策略结果
 */
public class GetBucketDisPolicyResult extends HeaderResponse {
    private DisPolicyConfiguration disPolicyConfiguration;

    public DisPolicyConfiguration getDisPolicyConfiguration() {
        return disPolicyConfiguration;
    }

    public void setDisPolicyConfiguration(DisPolicyConfiguration disPolicyConfiguration) {
        this.disPolicyConfiguration = disPolicyConfiguration;
    }
}