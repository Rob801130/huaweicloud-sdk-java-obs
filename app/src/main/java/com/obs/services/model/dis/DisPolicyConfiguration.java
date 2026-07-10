/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.dis;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * DIS通知策略配置
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DisPolicyConfiguration {
    private List<DisPolicyRule> rules;

    public DisPolicyConfiguration() {
    }

    public DisPolicyConfiguration(List<DisPolicyRule> rules) {
        this.rules = rules;
    }

    public List<DisPolicyRule> getRules() {
        return rules;
    }

    public void setRules(List<DisPolicyRule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "DisPolicyConfiguration{"
                + "rules=" + rules
                + '}';
    }
}