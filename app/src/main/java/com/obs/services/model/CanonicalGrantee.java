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

/**
 * ACL中被授权用户信息，{@link AccessControlList}
 */
public class CanonicalGrantee implements GranteeInterface {
    private String grantId;

    private String displayName;

    public CanonicalGrantee() {
    }

    /**
     * 构造函数
     *
     * @param identifier 被授权用户的DomainId
     */
    public CanonicalGrantee(String identifier) {
        this.grantId = identifier;
    }

    /**
     * 设置被授权用户的DomainId
     *
     * @param canonicalGrantId 被授权用户的DomainId
     */
    public void setIdentifier(String canonicalGrantId) {
        this.grantId = canonicalGrantId;
    }

    /**
     * 获取被授权用户的DomainId
     *
     * @return 被授权用户的DomainId
     */
    public String getIdentifier() {
        return grantId;
    }

    /**
     * 设置被授权用户的用户名
     *
     * @param displayName 被授权用户的用户名
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 获取被授权用户的用户名
     *
     * @return 被授权用户的用户名
     */
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grantId == null) ? 0 : grantId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CanonicalGrantee other = (CanonicalGrantee) obj;
        if (grantId == null) {
            return other.grantId == null;
        } else {
            return grantId.equals(other.grantId);
        }
    }

    public String toString() {
        return "CanonicalGrantee [id=" + grantId + (displayName != null ? ", displayName=" + displayName : "") + "]";
    }
}
