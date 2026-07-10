/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.mirrorback;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 镜像回源重定向配置
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MirrorBackRedirect {
    private String agency;

    private MirrorBackPublicSource publicSource;

    private List<String> retryConditions;

    private Boolean passQueryString;

    private Boolean mirrorFollowRedirect;

    private MirrorBackHttpHeader mirrorHttpHeader;

    private String replaceKeyWith;

    private String replaceKeyPrefixWith;

    private String vpcEndpointURN;

    private Boolean redirectWithoutReferer;

    private List<String> mirrorAllowHttpMethod;

    public MirrorBackRedirect() {
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public MirrorBackPublicSource getPublicSource() {
        return publicSource;
    }

    public void setPublicSource(MirrorBackPublicSource publicSource) {
        this.publicSource = publicSource;
    }

    public List<String> getRetryConditions() {
        return retryConditions;
    }

    public void setRetryConditions(List<String> retryConditions) {
        this.retryConditions = retryConditions;
    }

    public Boolean getPassQueryString() {
        return passQueryString;
    }

    public void setPassQueryString(Boolean passQueryString) {
        this.passQueryString = passQueryString;
    }

    public Boolean getMirrorFollowRedirect() {
        return mirrorFollowRedirect;
    }

    public void setMirrorFollowRedirect(Boolean mirrorFollowRedirect) {
        this.mirrorFollowRedirect = mirrorFollowRedirect;
    }

    public MirrorBackHttpHeader getMirrorHttpHeader() {
        return mirrorHttpHeader;
    }

    public void setMirrorHttpHeader(MirrorBackHttpHeader mirrorHttpHeader) {
        this.mirrorHttpHeader = mirrorHttpHeader;
    }

    public String getReplaceKeyWith() {
        return replaceKeyWith;
    }

    public void setReplaceKeyWith(String replaceKeyWith) {
        this.replaceKeyWith = replaceKeyWith;
    }

    public String getReplaceKeyPrefixWith() {
        return replaceKeyPrefixWith;
    }

    public void setReplaceKeyPrefixWith(String replaceKeyPrefixWith) {
        this.replaceKeyPrefixWith = replaceKeyPrefixWith;
    }

    public String getVpcEndpointURN() {
        return vpcEndpointURN;
    }

    public void setVpcEndpointURN(String vpcEndpointURN) {
        this.vpcEndpointURN = vpcEndpointURN;
    }

    public Boolean getRedirectWithoutReferer() {
        return redirectWithoutReferer;
    }

    public void setRedirectWithoutReferer(Boolean redirectWithoutReferer) {
        this.redirectWithoutReferer = redirectWithoutReferer;
    }

    public List<String> getMirrorAllowHttpMethod() {
        return mirrorAllowHttpMethod;
    }

    public void setMirrorAllowHttpMethod(List<String> mirrorAllowHttpMethod) {
        this.mirrorAllowHttpMethod = mirrorAllowHttpMethod;
    }

    @Override
    public String toString() {
        return "MirrorBackRedirect{"
                + "agency='" + agency + '\''
                + ", publicSource=" + publicSource
                + ", retryConditions=" + retryConditions
                + ", passQueryString=" + passQueryString
                + ", mirrorFollowRedirect=" + mirrorFollowRedirect
                + ", mirrorHttpHeader=" + mirrorHttpHeader
                + ", replaceKeyWith='" + replaceKeyWith + '\''
                + ", replaceKeyPrefixWith='" + replaceKeyPrefixWith + '\''
                + ", vpcEndpointURN='" + vpcEndpointURN + '\''
                + ", redirectWithoutReferer=" + redirectWithoutReferer
                + ", mirrorAllowHttpMethod=" + mirrorAllowHttpMethod
                + '}';
    }
}
