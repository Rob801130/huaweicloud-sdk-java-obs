/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.obs.services.model.BaseBucketRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 设置镜像回源策略请求
 */
public class SetBucketMirrorBackToSourceRequest extends BaseBucketRequest {
    {
        httpMethod = HttpMethodEnum.PUT;
    }

    private MirrorBackToSourceConfiguration mirrorBackToSourceConfiguration;

    public SetBucketMirrorBackToSourceRequest(String bucketName,
            MirrorBackToSourceConfiguration mirrorBackToSourceConfiguration) {
        super(bucketName);
        this.mirrorBackToSourceConfiguration = mirrorBackToSourceConfiguration;
    }

    public MirrorBackToSourceConfiguration getMirrorBackToSourceConfiguration() {
        return mirrorBackToSourceConfiguration;
    }

    public void setMirrorBackToSourceConfiguration(MirrorBackToSourceConfiguration mirrorBackToSourceConfiguration) {
        this.mirrorBackToSourceConfiguration = mirrorBackToSourceConfiguration;
    }
}
