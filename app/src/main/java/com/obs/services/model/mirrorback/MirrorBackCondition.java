/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 镜像回源匹配条件
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MirrorBackCondition {
    private String httpErrorCodeReturnedEquals;

    private String objectKeyPrefixEquals;

    public MirrorBackCondition() {
    }

    public MirrorBackCondition(String httpErrorCodeReturnedEquals, String objectKeyPrefixEquals) {
        this.httpErrorCodeReturnedEquals = httpErrorCodeReturnedEquals;
        this.objectKeyPrefixEquals = objectKeyPrefixEquals;
    }

    public String getHttpErrorCodeReturnedEquals() {
        return httpErrorCodeReturnedEquals;
    }

    public void setHttpErrorCodeReturnedEquals(String httpErrorCodeReturnedEquals) {
        this.httpErrorCodeReturnedEquals = httpErrorCodeReturnedEquals;
    }

    public String getObjectKeyPrefixEquals() {
        return objectKeyPrefixEquals;
    }

    public void setObjectKeyPrefixEquals(String objectKeyPrefixEquals) {
        this.objectKeyPrefixEquals = objectKeyPrefixEquals;
    }

    @Override
    public String toString() {
        return "MirrorBackCondition{"
                + "httpErrorCodeReturnedEquals='" + httpErrorCodeReturnedEquals + '\''
                + ", objectKeyPrefixEquals='" + objectKeyPrefixEquals + '\''
                + '}';
    }
}
