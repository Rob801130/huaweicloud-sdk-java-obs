/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 镜像回源配置
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MirrorBackToSourceConfiguration {
    private List<MirrorBackToSourceRule> rules;

    public MirrorBackToSourceConfiguration() {
    }

    public MirrorBackToSourceConfiguration(List<MirrorBackToSourceRule> rules) {
        this.rules = rules;
    }

    public List<MirrorBackToSourceRule> getRules() {
        return rules;
    }

    public void setRules(List<MirrorBackToSourceRule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "MirrorBackToSourceConfiguration{"
                + "rules=" + rules
                + '}';
    }
}
