/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.internal.xml;

import com.obs.log.ILogger;
import com.obs.log.LoggerBuilder;
import com.obs.services.exception.ObsException;
import com.obs.services.model.objectlock.ObjectLockConfiguration;
import com.obs.services.model.objectlock.ObjectLockRule;
import com.obs.services.model.objectlock.DefaultRetention;

public class ObjectLockConfigurationXMLBuilder extends ObsSimpleXMLBuilder {
    private static final ILogger log = LoggerBuilder.getLogger("com.obs.services.ObsClient");

    public static final String OBJECT_LOCK_CONFIGURATION = "ObjectLockConfiguration";
    public static final String OBJECT_LOCK_ENABLED = "ObjectLockEnabled";
    public static final String RULE = "Rule";
    public static final String DEFAULT_RETENTION = "DefaultRetention";
    public static final String MODE = "Mode";
    public static final String DAYS = "Days";
    public static final String YEARS = "Years";

    public String buildXML(ObjectLockConfiguration config) {
        checkConfiguration(config);
        startElement(OBJECT_LOCK_CONFIGURATION);

        if (config.getObjectLockEnabled() != null) {
            startElement(OBJECT_LOCK_ENABLED);
            append(config.getObjectLockEnabled());
            endElement(OBJECT_LOCK_ENABLED);
        }

        ObjectLockRule rule = config.getRule();
        if (rule != null && rule.getDefaultRetention() != null) {
            startElement(RULE);
            startElement(DEFAULT_RETENTION);

            DefaultRetention retention = rule.getDefaultRetention();
            if (retention.getMode() != null) {
                startElement(MODE);
                append(retention.getMode());
                endElement(MODE);
            }
            if (retention.getDays() != null) {
                startElement(DAYS);
                append(retention.getDays());
                endElement(DAYS);
            }
            if (retention.getYears() != null) {
                startElement(YEARS);
                append(retention.getYears());
                endElement(YEARS);
            }

            endElement(DEFAULT_RETENTION);
            endElement(RULE);
        }

        endElement(OBJECT_LOCK_CONFIGURATION);
        return getXmlBuilder().toString();
    }

    private void checkConfiguration(ObjectLockConfiguration config) {
        if (config == null) {
            String errorMessage = "ObjectLockConfiguration is null, failed to build request XML!";
            log.error(errorMessage);
            throw new ObsException(errorMessage);
        }
    }
}