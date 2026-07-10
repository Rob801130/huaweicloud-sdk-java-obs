/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.objectlock;

/**
 * 桶级默认WORM策略配置
 */
public class ObjectLockConfiguration {
    private String objectLockEnabled;
    private ObjectLockRule rule;

    public ObjectLockConfiguration() {
    }

    public ObjectLockConfiguration(String objectLockEnabled, ObjectLockRule rule) {
        this.objectLockEnabled = objectLockEnabled;
        this.rule = rule;
    }

    public String getObjectLockEnabled() {
        return objectLockEnabled;
    }

    public void setObjectLockEnabled(String objectLockEnabled) {
        this.objectLockEnabled = objectLockEnabled;
    }

    public ObjectLockRule getRule() {
        return rule;
    }

    public void setRule(ObjectLockRule rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        return "ObjectLockConfiguration [objectLockEnabled=" + objectLockEnabled + ", rule=" + rule + "]";
    }
}
