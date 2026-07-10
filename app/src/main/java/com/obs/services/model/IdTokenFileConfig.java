/**
 * Copyright 2019 Huawei Technologies Co.,Ltd.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.obs.services.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ID Token 文件配置（JSON 结构）
 *
 * <p>此类用于解析和存储 id_token_file JSON 配置文件的内容。
 * 配置文件包含 ID Token 联邦认证所需的所有参数。</p>
 *
 * <p><b>重要约束</b>：project 和 domain 互斥，只能选择其一，不能同时指定。两者均可选，均不指定时获取 unscoped token。</p>
 *
 * <p><b>示例配置文件（使用 project）</b>：</p>
 * <pre>{@code
 * {
 *     "id_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
 *     "idp_id": "my-idp-id",
 *     "project_id": "project-123",
 *     "iam_endpoint": "https://iam.cn-north-4.myhuaweicloud.com",
 *     "refresh_before_seconds": 300,
 *     "max_retry_times": 3,
 *     "credential_expires_seconds": 3600
 * }
 * }</pre>
 *
 * <p><b>示例配置文件（使用 domain）</b>：</p>
 * <pre>{@code
 * {
 *     "id_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
 *     "idp_id": "my-idp-id",
 *     "domain_id": "domain-456",
 *     "iam_endpoint": "https://iam.cn-north-4.myhuaweicloud.com",
 *     "refresh_before_seconds": 300,
 *     "max_retry_times": 3,
 *     "credential_expires_seconds": 3600
 * }
 * }</pre>
 */
public class IdTokenFileConfig {

    /**
     * ID Token 字符串（JWT 格式）
     * 由 IdP 签发，用于身份认证
     * 与 oidc_token_file 互斥
     */
    @JsonProperty("id_token")
    private String idToken;

    /**
     * OIDC Token 文件路径（纯文本 JWT）
     * 文件内容为 JWT Token 字符串，读取时自动 strip 空白字符
     * 与 id_token 互斥
     */
    @JsonProperty("oidc_token_file")
    private String oidcTokenFile;

    /**
     * 身份提供商 ID
     * 需与华为云 IAM 中创建的 IdP 名称一致
     */
    @JsonProperty("idp_id")
    private String idpId;

    /**
     * IAM 服务地址（可选）
     * 如不指定则使用构造时传入的默认值或华为云公共端点
     */
    @JsonProperty("iam_endpoint")
    private String iamEndpoint;

    /**
     * 项目 ID（与 domain 互斥，可选）
     * 用于指定访问的项目范围，可与 projectName 同时指定
     */
    @JsonProperty("project_id")
    private String projectId;

    /**
     * 项目名称（与 domain 互斥，可选）
     * 可与 projectId 同时指定，服务端优先使用 projectId
     */
    @JsonProperty("project_name")
    private String projectName;

    /**
     * 华为云账号 ID（与 project 互斥，可选）
     * 用于标识资源所有者，可与 domainName 同时指定
     */
    @JsonProperty("domain_id")
    private String domainId;

    /**
     * 华为云账号名（与 project 互斥，可选）
     * 可与 domainId 同时指定，服务端优先使用 domainId
     */
    @JsonProperty("domain_name")
    private String domainName;

    /**
     * 提前刷新秒数（默认 300 秒）
     * 在凭证过期前该秒数时自动刷新
     */
    @JsonProperty("refresh_before_seconds")
    private int refreshBeforeSeconds = 300;

    /**
     * 最大重试次数（默认 3 次）
     * 网络请求失败时的最大重试次数
     */
    @JsonProperty("max_retry_times")
    private int maxRetryTimes = 3;

    /**
     * 临时凭证有效期秒数（默认 86400 秒，最小 900，最大 86400）
     * 用于指定从 IAM 获取的临时 AK/SK/SecurityToken 的有效期
     */
    @JsonProperty("credential_expires_seconds")
    private Integer credentialExpiresSeconds = 86400;

    /**
     * 代理主机地址（可选）
     * 用于通过 HTTP 代理访问 IAM 服务
     */
    @JsonProperty("proxy_host")
    private String proxyHost;

    /**
     * 代理端口号（可选，默认 0 表示未设置）
     * 与 proxyHost 配合使用
     */
    @JsonProperty("proxy_port")
    private int proxyPort = 0;

    /**
     * 代理用户名（可选）
     * 用于代理认证，为 null 时不使用代理认证
     */
    @JsonProperty("proxy_username")
    private String proxyUsername;

    /**
     * 代理密码（可选）
     * 用于代理认证，为 null 时不使用代理认证
     */
    @JsonProperty("proxy_password")
    private String proxyPassword;

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getOidcTokenFile() {
        return oidcTokenFile;
    }

    public void setOidcTokenFile(String oidcTokenFile) {
        this.oidcTokenFile = oidcTokenFile;
    }

    public String getIdpId() {
        return idpId;
    }

    public void setIdpId(String idpId) {
        this.idpId = idpId;
    }

    public String getIamEndpoint() {
        return iamEndpoint;
    }

    public void setIamEndpoint(String iamEndpoint) {
        this.iamEndpoint = iamEndpoint;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public int getRefreshBeforeSeconds() {
        return refreshBeforeSeconds;
    }

    public void setRefreshBeforeSeconds(int refreshBeforeSeconds) {
        this.refreshBeforeSeconds = refreshBeforeSeconds;
    }

    public int getMaxRetryTimes() {
        return maxRetryTimes;
    }

    public void setMaxRetryTimes(int maxRetryTimes) {
        this.maxRetryTimes = maxRetryTimes;
    }

    public Integer getCredentialExpiresSeconds() {
        return credentialExpiresSeconds;
    }

    public void setCredentialExpiresSeconds(Integer credentialExpiresSeconds) {
        this.credentialExpiresSeconds = credentialExpiresSeconds;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProxyUsername() {
        return proxyUsername;
    }

    public void setProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    /**
     * 判断是否配置了代理
     *
     * @return true 表示配置了代理主机地址
     */
    public boolean hasProxy() {
        return isNotBlank(proxyHost);
    }

    /**
     * 判断是否使用了 project 模式
     *
     * @return true 表示配置中包含 project 信息
     */
    public boolean hasProject() {
        return isNotBlank(projectId) || isNotBlank(projectName);
    }

    /**
     * 判断是否使用了 domain 模式
     *
     * @return true 表示配置中包含 domain 信息
     */
    public boolean hasDomain() {
        return isNotBlank(domainId) || isNotBlank(domainName);
    }

    private static boolean isNotBlank(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
