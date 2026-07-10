/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.objectlock;

import com.obs.services.model.BaseBucketRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 配置桶级默认WORM策略请求
 */
public class SetObjectLockConfigurationRequest extends BaseBucketRequest {
    {
        httpMethod = HttpMethodEnum.PUT;
    }

    private ObjectLockConfiguration objectLockConfiguration;

    public SetObjectLockConfigurationRequest(String bucketName, ObjectLockConfiguration objectLockConfiguration) {
        super(bucketName);
        this.objectLockConfiguration = objectLockConfiguration;
    }

    public ObjectLockConfiguration getObjectLockConfiguration() {
        return objectLockConfiguration;
    }

    public void setObjectLockConfiguration(ObjectLockConfiguration objectLockConfiguration) {
        this.objectLockConfiguration = objectLockConfiguration;
    }
}
