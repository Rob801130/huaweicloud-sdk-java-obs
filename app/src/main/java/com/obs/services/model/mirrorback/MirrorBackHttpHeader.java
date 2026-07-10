/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 镜像回源HTTP头传递规则
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MirrorBackHttpHeader {
    private Boolean passAll;

    private List<String> pass;

    private List<String> remove;

    private List<MirrorBackHttpHeaderSet> set;

    public MirrorBackHttpHeader() {
    }

    public Boolean getPassAll() {
        return passAll;
    }

    public void setPassAll(Boolean passAll) {
        this.passAll = passAll;
    }

    public List<String> getPass() {
        return pass;
    }

    public void setPass(List<String> pass) {
        this.pass = pass;
    }

    public List<String> getRemove() {
        return remove;
    }

    public void setRemove(List<String> remove) {
        this.remove = remove;
    }

    public List<MirrorBackHttpHeaderSet> getSet() {
        return set;
    }

    public void setSet(List<MirrorBackHttpHeaderSet> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "MirrorBackHttpHeader{"
                + "passAll=" + passAll
                + ", pass=" + pass
                + ", remove=" + remove
                + ", set=" + set
                + '}';
    }
}
