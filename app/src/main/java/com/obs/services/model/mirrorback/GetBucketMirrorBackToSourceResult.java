/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.obs.services.model.HeaderResponse;

/**
 * 获取镜像回源策略结果
 */
public class GetBucketMirrorBackToSourceResult extends HeaderResponse {
    private MirrorBackToSourceConfiguration mirrorBackToSourceConfiguration;

    public MirrorBackToSourceConfiguration getMirrorBackToSourceConfiguration() {
        return mirrorBackToSourceConfiguration;
    }

    public void setMirrorBackToSourceConfiguration(MirrorBackToSourceConfiguration mirrorBackToSourceConfiguration) {
        this.mirrorBackToSourceConfiguration = mirrorBackToSourceConfiguration;
    }
}
