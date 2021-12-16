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

import java.io.File;
import java.io.InputStream;

/**
 * 写文件内容的请求参数
 *
 */
public class ModifyObjectRequest extends AppendObjectRequest {

    {
        this.httpMethod = HttpMethodEnum.PUT;
    }

    public ModifyObjectRequest() {
    }

    /**
     * 构造函数
     * 
     * @param bucketName
     *            桶名
     * @param objectKey
     *            文件名
     */
    public ModifyObjectRequest(String bucketName, String objectKey) {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
    }

    /**
     * 构造函数
     * 
     * @param bucketName
     *            桶名
     * @param objectKey
     *            文件名
     * @param file
     *            本地文件路径
     */
    public ModifyObjectRequest(String bucketName, String objectKey, File file) {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.file = file;
    }

    /**
     * 构造函数
     * 
     * @param bucketName
     *            桶名
     * @param objectKey
     *            文件名
     * @param file
     *            本地文件路径
     * @param position
     *            写文件的起始位置
     */
    public ModifyObjectRequest(String bucketName, String objectKey, File file, long position) {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.file = file;
        this.position = position;
    }

    /**
     * 构造函数
     * 
     * @param bucketName
     *            桶名
     * @param objectKey
     *            文件名
     * @param input
     *            待上传的数据流
     */
    public ModifyObjectRequest(String bucketName, String objectKey, InputStream input) {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.input = input;
    }

    /**
     * 构造函数
     * 
     * @param bucketName
     *            桶名
     * @param objectKey
     *            文件名
     * @param input
     *            待上传的数据流
     * @param position
     *            写文件的起始位置
     */
    public ModifyObjectRequest(String bucketName, String objectKey, InputStream input, long position) {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.input = input;
        this.position = position;
    }
}
