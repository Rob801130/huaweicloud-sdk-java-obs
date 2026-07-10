/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package com.obs.services.model.dis;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * DIS通知策略规则
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DisPolicyRule {
    private String id;

    private String stream;

    private String project;

    private List<String> events;

    private String prefix;

    private String suffix;

    private String agency;

    public DisPolicyRule() {
    }

    public DisPolicyRule(String id, String stream, String project, List<String> events, String agency) {
        this.id = id;
        this.stream = stream;
        this.project = project;
        this.events = events;
        this.agency = agency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
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

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return "DisPolicyRule{"
                + "id='" + id + '\''
                + ", stream='" + stream + '\''
                + ", project='" + project + '\''
                + ", events=" + events
                + ", prefix='" + prefix + '\''
                + ", suffix='" + suffix + '\''
                + ", agency='" + agency + '\''
                + '}';
    }
}