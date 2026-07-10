/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 镜像回源规则
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MirrorBackToSourceRule {
    private String id;

    private MirrorBackCondition condition;

    private MirrorBackRedirect redirect;

    public MirrorBackToSourceRule() {
    }

    public MirrorBackToSourceRule(String id, MirrorBackCondition condition, MirrorBackRedirect redirect) {
        this.id = id;
        this.condition = condition;
        this.redirect = redirect;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MirrorBackCondition getCondition() {
        return condition;
    }

    public void setCondition(MirrorBackCondition condition) {
        this.condition = condition;
    }

    public MirrorBackRedirect getRedirect() {
        return redirect;
    }

    public void setRedirect(MirrorBackRedirect redirect) {
        this.redirect = redirect;
    }

    @Override
    public String toString() {
        return "MirrorBackToSourceRule{"
                + "id='" + id + '\''
                + ", condition=" + condition
                + ", redirect=" + redirect
                + '}';
    }
}
