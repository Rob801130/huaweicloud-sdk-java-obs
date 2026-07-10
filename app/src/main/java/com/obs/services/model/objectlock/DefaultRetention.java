/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.objectlock;

/**
 * 桶级默认WORM保护策略
 */
public class DefaultRetention {
    private String mode;
    private Integer days;
    private Integer years;

    public DefaultRetention() {
    }

    public DefaultRetention(String mode, Integer days, Integer years) {
        this.mode = mode;
        this.days = days;
        this.years = years;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "DefaultRetention [mode=" + mode + ", days=" + days + ", years=" + years + "]";
    }
}
