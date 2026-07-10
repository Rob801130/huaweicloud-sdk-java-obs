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

package com.obs.services.internal.security;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 联邦认证 Token 响应
 *
 * <p>对应 IAM 联邦认证接口 POST /v3.0/OS-AUTH/id-token/tokens 的响应体。</p>
 *
 * <p>响应示例：</p>
 * <pre>{@code
 * {
 *     "token": {
 *         "expires_at": "2024-01-15T10:00:00.000Z",
 *         "methods": ["federation"],
 *         ...
 *     }
 * }
 * }</pre>
 *
 * <p>注意：联邦认证 Token 本身通过响应头 X-Subject-Token 返回，
 * 此类仅用于解析响应体中的 token 信息。</p>
 */
public class FederationTokenResponse {

    @JsonProperty("token")
    private TokenInfo tokenInfo;

    public TokenInfo getTokenInfo() {
        return tokenInfo;
    }

    public void setTokenInfo(TokenInfo tokenInfo) {
        this.tokenInfo = tokenInfo;
    }

    /**
     * 联邦认证 Token 信息
     */
    public static class TokenInfo {

        @JsonProperty("expires_at")
        private String expiresAt;

        public String getExpiresAt() {
            return expiresAt;
        }

        public void setExpiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
        }
    }
}
