/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.compress;

import com.obs.services.model.HeaderResponse;

/**
 * 获取在线解压策略结果
 */
public class GetBucketCompressPolicyResult extends HeaderResponse {
    private CompressPolicyConfiguration compressPolicyConfiguration;

    public CompressPolicyConfiguration getCompressPolicyConfiguration() {
        return compressPolicyConfiguration;
    }

    public void setCompressPolicyConfiguration(CompressPolicyConfiguration compressPolicyConfiguration) {
        this.compressPolicyConfiguration = compressPolicyConfiguration;
    }
}