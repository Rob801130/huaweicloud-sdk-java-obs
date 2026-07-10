/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.objectlock;

import com.obs.services.model.HeaderResponse;

/**
 * 获取桶级默认WORM策略响应
 */
public class GetObjectLockConfigurationResult extends HeaderResponse {
    private ObjectLockConfiguration objectLockConfiguration;

    public ObjectLockConfiguration getObjectLockConfiguration() {
        return objectLockConfiguration;
    }

    public void setObjectLockConfiguration(ObjectLockConfiguration objectLockConfiguration) {
        this.objectLockConfiguration = objectLockConfiguration;
    }
}
