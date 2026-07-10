/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 镜像回源源端地址配置
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MirrorBackSourceEndpoint {
    private List<String> master;

    private List<String> slave;

    public MirrorBackSourceEndpoint() {
    }

    public MirrorBackSourceEndpoint(List<String> master, List<String> slave) {
        this.master = master;
        this.slave = slave;
    }

    public List<String> getMaster() {
        return master;
    }

    public void setMaster(List<String> master) {
        this.master = master;
    }

    public List<String> getSlave() {
        return slave;
    }

    public void setSlave(List<String> slave) {
        this.slave = slave;
    }

    @Override
    public String toString() {
        return "MirrorBackSourceEndpoint{"
                + "master=" + master
                + ", slave=" + slave
                + '}';
    }
}
