/**
 * Copyright 2019 Huawei Technologies Co.,Ltd.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.obs.services.model;

/**
 * 删除对象的请求参数
 * 
 * @since 3.20.3
 */
public class DeleteObjectRequest extends BaseObjectRequest {

    {
        httpMethod = HttpMethodEnum.DELETE;
    }

    private String versionId;

    public DeleteObjectRequest() {
    }

    public DeleteObjectRequest(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * 构造函数
     * 
     * @param bucketName
     *            桶名
     * @param objectKey
     *            对象名
     */
    public DeleteObjectRequest(String bucketName, String objectKey) {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
    }
    
    /**
     * 构造函数
     * 
     * @param bucketName
     *            桶名
     * @param objectKey
     *            对象名
     * @param versionId
     *            对象版本号
     */
    public DeleteObjectRequest(String bucketName, String objectKey, String versionId) {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.versionId = versionId;
    }

    /**
     * 获取待删除的对象版本号
     * 
     * @return 标识待删除对象的版本号
     */
    public String getVersionId() {
        return versionId;
    }

    /**
     * 设置待删除对象的版本号
     * 
     * @param versionId
     *            标识待删除对象的版本号
     */
    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    @Override
    public String toString() {
        return "AbortMultipartUploadRequest [bucketName=" + bucketName + ", objectKey="
                + objectKey + ", versionId=" + versionId + "]";
    }

}
