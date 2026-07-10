/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.compress;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 在线解压策略配置
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompressPolicyConfiguration {
    private List<CompressPolicyRule> rules;

    public CompressPolicyConfiguration() {
    }

    public CompressPolicyConfiguration(List<CompressPolicyRule> rules) {
        this.rules = rules;
    }

    public List<CompressPolicyRule> getRules() {
        return rules;
    }

    public void setRules(List<CompressPolicyRule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "CompressPolicyConfiguration{"
                + "rules=" + rules
                + '}';
    }
}