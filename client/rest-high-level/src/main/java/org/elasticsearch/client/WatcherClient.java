/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.client;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.client.watcher.DeactivateWatchRequest;
import org.elasticsearch.client.watcher.DeactivateWatchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.watcher.ActivateWatchRequest;
import org.elasticsearch.client.watcher.ActivateWatchResponse;
import org.elasticsearch.client.watcher.AckWatchRequest;
import org.elasticsearch.client.watcher.AckWatchResponse;
import org.elasticsearch.client.watcher.StartWatchServiceRequest;
import org.elasticsearch.client.watcher.StopWatchServiceRequest;
import org.elasticsearch.client.watcher.DeleteWatchRequest;
import org.elasticsearch.client.watcher.DeleteWatchResponse;
import org.elasticsearch.client.watcher.PutWatchRequest;
import org.elasticsearch.client.watcher.PutWatchResponse;
import org.elasticsearch.client.watcher.WatcherStatsRequest;
import org.elasticsearch.client.watcher.WatcherStatsResponse;

import java.io.IOException;

import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;

public final class WatcherClient {

    private final RestHighLevelClient restHighLevelClient;

    WatcherClient(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    /**
     * Start the watch service
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-start.html">
     * the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public AcknowledgedResponse startWatchService(StartWatchServiceRequest request, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(
                request, WatcherRequestConverters::startWatchService, options, AcknowledgedResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously start the watch service
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-start.html">
     * the docs</a> for more.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
    public void startWatchServiceAsync(StartWatchServiceRequest request, RequestOptions options,
            ActionListener<AcknowledgedResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(
                request, WatcherRequestConverters::startWatchService, options, AcknowledgedResponse::fromXContent, listener, emptySet());
    }

    /**
     * Stop the watch service
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-start.html">
     * the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public AcknowledgedResponse stopWatchService(StopWatchServiceRequest request, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(
                request, WatcherRequestConverters::stopWatchService, options, AcknowledgedResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously stop the watch service
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-start.html">
     * the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     */
    public void stopWatchServiceAsync(StopWatchServiceRequest request, RequestOptions options,
            ActionListener<AcknowledgedResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(
                request, WatcherRequestConverters::stopWatchService, options, AcknowledgedResponse::fromXContent, listener, emptySet());
    }

    /**
     * Put a watch into the cluster
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-put-watch.html">
     * the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public PutWatchResponse putWatch(PutWatchRequest request, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request, WatcherRequestConverters::putWatch, options,
            PutWatchResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously put a watch into the cluster
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-put-watch.html">
     * the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void putWatchAsync(PutWatchRequest request, RequestOptions options,
                              ActionListener<PutWatchResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request, WatcherRequestConverters::putWatch, options,
            PutWatchResponse::fromXContent, listener, emptySet());
    }

    /**
     * Deactivate an existing watch
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-deactivate-watch.html">
     *     the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public DeactivateWatchResponse deactivateWatch(DeactivateWatchRequest request, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request, WatcherRequestConverters::deactivateWatch, options,
            DeactivateWatchResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously deactivate an existing watch
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-deactivate-watch.html">
     *     the docs</a> for more.
     *
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void deactivateWatchAsync(DeactivateWatchRequest request, RequestOptions options,
                                     ActionListener<DeactivateWatchResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request, WatcherRequestConverters::deactivateWatch, options,
            DeactivateWatchResponse::fromXContent, listener, emptySet());
    }

    /**
     * Deletes a watch from the cluster
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-delete-watch.html">
     * the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public DeleteWatchResponse deleteWatch(DeleteWatchRequest request, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request, WatcherRequestConverters::deleteWatch, options,
            DeleteWatchResponse::fromXContent, singleton(404));
    }

    /**
     * Asynchronously deletes a watch from the cluster
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-delete-watch.html">
     * the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void deleteWatchAsync(DeleteWatchRequest request, RequestOptions options, ActionListener<DeleteWatchResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request, WatcherRequestConverters::deleteWatch, options,
            DeleteWatchResponse::fromXContent, listener, singleton(404));
    }

    /**
     * Acknowledges a watch.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-ack-watch.html">
     * the docs</a> for more information.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException if there is a problem sending the request or parsing back the response
     */
    public AckWatchResponse ackWatch(AckWatchRequest request, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request, WatcherRequestConverters::ackWatch, options,
            AckWatchResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously acknowledges a watch.
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-ack-watch.html">
     * the docs</a> for more information.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon completion of the request
     */
    public void ackWatchAsync(AckWatchRequest request, RequestOptions options, ActionListener<AckWatchResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request, WatcherRequestConverters::ackWatch, options,
            AckWatchResponse::fromXContent, listener, emptySet());
    }

    /**
     * Activate a watch from the cluster
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-activate-watch.html">
     * the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public ActivateWatchResponse activateWatch(ActivateWatchRequest request, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request, WatcherRequestConverters::activateWatch, options,
            ActivateWatchResponse::fromXContent, singleton(404));
    }

    /**
     * Asynchronously activates a watch from the cluster
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-activate-watch.html">
     * the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void activateWatchAsync(ActivateWatchRequest request, RequestOptions options, ActionListener<ActivateWatchResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request, WatcherRequestConverters::activateWatch, options,
            ActivateWatchResponse::fromXContent, listener, singleton(404));
    }

    /**
     * Get the watcher stats
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-stats.html">
     * the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    public WatcherStatsResponse watcherStats(WatcherStatsRequest request, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAndParseEntity(request, WatcherRequestConverters::watcherStats, options,
            WatcherStatsResponse::fromXContent, emptySet());
    }

    /**
     * Asynchronously get the watcher stats
     * See <a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/watcher-api-stats.html">
     * the docs</a> for more.
     * @param request the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
     */
    public void watcherStatsAsync(WatcherStatsRequest request, RequestOptions options, ActionListener<WatcherStatsResponse> listener) {
        restHighLevelClient.performRequestAsyncAndParseEntity(request, WatcherRequestConverters::watcherStats, options,
            WatcherStatsResponse::fromXContent, listener, emptySet());
    }

}
