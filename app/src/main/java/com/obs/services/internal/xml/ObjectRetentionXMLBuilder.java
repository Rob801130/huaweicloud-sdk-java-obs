/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2026-2026. All rights reserved.
 */

package com.obs.services.internal.xml;

import com.obs.log.ILogger;
import com.obs.log.LoggerBuilder;
import com.obs.services.exception.ObsException;
import com.obs.services.model.objectlock.ObjectRetention;

public class ObjectRetentionXMLBuilder extends ObsSimpleXMLBuilder {
    private static final ILogger log = LoggerBuilder.getLogger("com.obs.services.ObsClient");

    public static final String RETENTION = "Retention";
    public static final String MODE = "Mode";
    public static final String RETAIN_UNTIL_DATE = "RetainUntilDate";

    public String buildXML(ObjectRetention retention) {
        checkRetention(retention);
        startElement(RETENTION);

        if (retention.getMode() != null) {
            startElement(MODE);
            append(retention.getMode());
            endElement(MODE);
        }
        if (retention.getRetainUntilDate() != null) {
            startElement(RETAIN_UNTIL_DATE);
            append(String.valueOf(retention.getRetainUntilDate()));
            endElement(RETAIN_UNTIL_DATE);
        }

        endElement(RETENTION);
        return getXmlBuilder().toString();
    }

    private void checkRetention(ObjectRetention retention) {
        if (retention == null) {
            String errorMessage = "ObjectRetention is null, failed to build request XML!";
            log.error(errorMessage);
            throw new ObsException(errorMessage);
        }
    }
}