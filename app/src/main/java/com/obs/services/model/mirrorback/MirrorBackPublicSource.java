/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 镜像回源公共源配置
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MirrorBackPublicSource {
    private MirrorBackSourceEndpoint sourceEndpoint;

    public MirrorBackPublicSource() {
    }

    public MirrorBackPublicSource(MirrorBackSourceEndpoint sourceEndpoint) {
        this.sourceEndpoint = sourceEndpoint;
    }

    public MirrorBackSourceEndpoint getSourceEndpoint() {
        return sourceEndpoint;
    }

    public void setSourceEndpoint(MirrorBackSourceEndpoint sourceEndpoint) {
        this.sourceEndpoint = sourceEndpoint;
    }

    @Override
    public String toString() {
        return "MirrorBackPublicSource{"
                + "sourceEndpoint=" + sourceEndpoint
                + '}';
    }
}
