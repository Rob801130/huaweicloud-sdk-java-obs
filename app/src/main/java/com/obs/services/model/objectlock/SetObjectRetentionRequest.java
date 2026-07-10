/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.model.objectlock;

import com.obs.services.model.BaseObjectRequest;
import com.obs.services.model.HttpMethodEnum;

/**
 * 配置对象级WORM保护策略的请求参数
 *
 * @since 3.24.4
 */
public class SetObjectRetentionRequest extends BaseObjectRequest {

    {
        httpMethod = HttpMethodEnum.PUT;
    }

    private ObjectRetention retention;

    private String versionId;

    public SetObjectRetentionRequest() {
    }

    /**
     * Constructor
     *
     * @param bucketName
     *            桶名
     * @param objectKey
     *            对象名
     * @param retention
     *            对象级WORM保护策略配置
     */
    public SetObjectRetentionRequest(String bucketName, String objectKey, ObjectRetention retention) {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.retention = retention;
    }

    /**
     * Constructor
     *
     * @param bucketName
     *            桶名
     * @param objectKey
     *            对象名
     * @param retention
     *            对象级WORM保护策略配置
     * @param versionId
     *            对象版本号
     */
    public SetObjectRetentionRequest(String bucketName, String objectKey, ObjectRetention retention,
            String versionId) {
        this.bucketName = bucketName;
        this.objectKey = objectKey;
        this.retention = retention;
        this.versionId = versionId;
    }

    /**
     * 获取对象级WORM保护策略配置
     *
     * @return 对象级WORM保护策略配置
     */
    public ObjectRetention getRetention() {
        return retention;
    }

    /**
     * 设置对象级WORM保护策略配置
     *
     * @param retention
     *            对象级WORM保护策略配置
     */
    public void setRetention(ObjectRetention retention) {
        this.retention = retention;
    }

    /**
     * 获取对象版本号
     *
     * @return 对象版本号
     */
    public String getVersionId() {
        return versionId;
    }

    /**
     * 设置对象版本号
     *
     * @param versionId
     *            对象版本号
     */
    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    @Override
    public String toString() {
        return "SetObjectRetentionRequest [bucketName=" + bucketName + ", objectKey=" + objectKey + ", versionId="
                + versionId + ", retention=" + retention + "]";
    }
}
