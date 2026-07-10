/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.objectlock;

/**
 * 桶级WORM策略规则容器
 */
public class ObjectLockRule {
    private DefaultRetention defaultRetention;

    public ObjectLockRule() {
    }

    public ObjectLockRule(DefaultRetention defaultRetention) {
        this.defaultRetention = defaultRetention;
    }

    public DefaultRetention getDefaultRetention() {
        return defaultRetention;
    }

    public void setDefaultRetention(DefaultRetention defaultRetention) {
        this.defaultRetention = defaultRetention;
    }

    @Override
    public String toString() {
        return "ObjectLockRule [defaultRetention=" + defaultRetention + "]";
    }
}
