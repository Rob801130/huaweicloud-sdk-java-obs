/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 镜像回源HTTP头设置项
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MirrorBackHttpHeaderSet {
    private String key;

    private String value;

    public MirrorBackHttpHeaderSet() {
    }

    public MirrorBackHttpHeaderSet(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MirrorBackHttpHeaderSet{"
                + "key='" + key + '\''
                + ", value='" + value + '\''
                + '}';
    }
}
