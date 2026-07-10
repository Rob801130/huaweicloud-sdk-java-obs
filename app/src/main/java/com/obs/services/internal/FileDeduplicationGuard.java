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

package com.obs.services.internal;

import com.obs.log.ILogger;
import com.obs.log.LoggerBuilder;
import com.obs.services.exception.ObsException;
import com.obs.services.model.DownloadFileRequest;

import java.util.concurrent.ConcurrentHashMap;

/**
 * File deduplication guard for downloadFile operations.
 * <p>
 * Prevents multiple concurrent download tasks from writing to the same local file,
 * which could cause data corruption or inconsistent file content.
 * </p>
 * <p>
 * This guard uses the downloadFile path as the deduplication key. When enabled,
 * simultaneous downloads to the same local file will be rejected with an exception.
 * </p>
 * <p>
 * <b>Process-level scope</b>: The deduplication map is static, meaning all ObsClient
 * instances within the same JVM process share the same deduplication state. This
 * ensures that even different ObsClient instances cannot download to the same local
 * file simultaneously.
 * </p>
 * <p>
 * <b>Singleton pattern</b>: This class uses the enum singleton pattern to ensure
 * there is only one instance throughout the JVM lifecycle. Access via
 * {@link #INSTANCE}.
 * </p>
 *
 * @since 3.0.0
 */
public enum FileDeduplicationGuard {

    /**
     * Singleton instance of FileDeduplicationGuard.
     */
    INSTANCE;

    private static final ILogger ILOG = LoggerBuilder.getLogger(FileDeduplicationGuard.class);

    /**
     * Static deduplication map shared across all ObsClient instances in the same JVM.
     * Process-level deduplication ensures that different ObsClient instances cannot
     * download to the same local file simultaneously.
     */
    private static final ConcurrentHashMap<String, Object> DEDUPLICATION_MAP = new ConcurrentHashMap<>();

    /**
     * Acquires the deduplication lock for the given download request.
     * <p>
     * If another download task is already in progress for the same downloadFile,
     * this method throws an ObsException immediately.
     * </p>
     * <p>
     * This method is process-safe: even if a different ObsClient instance starts
     * a download to the same file, it will be rejected.
     * </p>
     *
     * @param request the download file request
     * @throws ObsException if a duplicate download task is detected
     */
    public void acquire(DownloadFileRequest request) {
        String key = request.getDownloadFile();
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("downloadFile cannot be null or empty");
        }

        Object lock = new Object();
        Object existing = DEDUPLICATION_MAP.putIfAbsent(key, lock);
        if (existing != null) {
            if (ILOG.isWarnEnabled()) {
                ILOG.warn("Duplicate download task detected for downloadFile: " + key);
            }
            throw new ObsException(
                    "Duplicate download task detected. " +
                    "A download task is already in progress for downloadFile: " + key + ". " +
                    "Please wait for the existing task to complete or use a different downloadFile path."
            );
        }

        if (ILOG.isDebugEnabled()) {
            ILOG.debug("Acquired deduplication lock for downloadFile: " + key);
        }
    }

    /**
     * Releases the deduplication lock for the given download request.
     * <p>
     * This method should always be called in a finally block to ensure
     * the lock is released even if an exception occurs.
     * </p>
     *
     * @param request the download file request
     */
    public void release(DownloadFileRequest request) {
        String key = request.getDownloadFile();
        if (key != null) {
            DEDUPLICATION_MAP.remove(key);
            if (ILOG.isDebugEnabled()) {
                ILOG.debug("Released deduplication lock for downloadFile: " + key);
            }
        }
    }

    /**
     * Checks if a download task is currently in progress for the given downloadFile.
     * <p>
     * This method checks the process-wide deduplication state.
     * </p>
     *
     * @param downloadFile the local file path to check
     * @return true if a download task is in progress, false otherwise
     */
    public boolean isDownloadInProgress(String downloadFile) {
        return DEDUPLICATION_MAP.containsKey(downloadFile);
    }

    /**
     * Clears the deduplication map.
     * <p>
     * This method is intended for testing purposes only.
     * </p>
     */
    public static void clear() {
        DEDUPLICATION_MAP.clear();
    }

    /**
     * Gets the current size of the deduplication map.
     * <p>
     * This method is intended for testing purposes only.
     * </p>
     *
     * @return the number of entries in the deduplication map
     */
    public static int size() {
        return DEDUPLICATION_MAP.size();
    }
}