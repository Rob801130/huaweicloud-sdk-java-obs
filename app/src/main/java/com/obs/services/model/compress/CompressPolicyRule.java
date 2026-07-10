/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.compress;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 在线解压策略规则
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompressPolicyRule {
    private String id;

    private String project;

    private String agency;

    private List<String> events;

    private String prefix;

    private String suffix;

    private Integer overwrite;

    private String decompresspath;

    private String policytype;

    public CompressPolicyRule() {
    }

    public CompressPolicyRule(String id, String project, String agency, List<String> events, String suffix,
                              Integer overwrite) {
        this.id = id;
        this.project = project;
        this.agency = agency;
        this.events = events;
        this.suffix = suffix;
        this.overwrite = overwrite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getOverwrite() {
        return overwrite;
    }

    public void setOverwrite(Integer overwrite) {
        this.overwrite = overwrite;
    }

    public String getDecompresspath() {
        return decompresspath;
    }

    public void setDecompresspath(String decompresspath) {
        this.decompresspath = decompresspath;
    }

    public String getPolicytype() {
        return policytype;
    }

    public void setPolicytype(String policytype) {
        this.policytype = policytype;
    }

    @Override
    public String toString() {
        return "CompressPolicyRule{"
                + "id='" + id + '\''
                + ", project='" + project + '\''
                + ", agency='" + agency + '\''
                + ", events=" + events
                + ", prefix='" + prefix + '\''
                + ", suffix='" + suffix + '\''
                + ", overwrite=" + overwrite
                + ", decompresspath='" + decompresspath + '\''
                + ", policytype='" + policytype + '\''
                + '}';
    }
}