package org.openremote.manager.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import org.openremote.manager.server.identity.IdentityService;
import org.openremote.manager.server.persistence.PersistenceService;
import org.openremote.manager.server.map.MapService;
import org.openremote.manager.server.contextbroker.*;
import org.openremote.manager.server.util.JsonUtil;
import org.openremote.manager.server.web.WebService;

import java.util.logging.Logger;

import static org.openremote.manager.server.Constants.DEV_MODE;
import static org.openremote.manager.server.Constants.DEV_MODE_DEFAULT;

public class ServerVerticle extends AbstractVerticle {

    private static final Logger LOG = Logger.getLogger(ServerVerticle.class.getName());

    static {
        // One-time static configuration goes here
        JsonUtil.configure(Json.mapper);
    }

    protected boolean devMode;
    protected SampleData sampleData;

    protected IdentityService identityService;
    protected ContextBrokerService contextBrokerService;
    protected MapService mapService;
    protected PersistenceService persistenceService;
    protected WebService webService;

    @Override
    public void start(Future<Void> startFuture) {

        devMode = config().getBoolean(DEV_MODE, DEV_MODE_DEFAULT);

        vertx.executeBlocking(
            blocking -> {

                identityService = new IdentityService();
                identityService.start(vertx, config());

                contextBrokerService = new ContextBrokerService();
                contextBrokerService.start(vertx, config());

                mapService = new MapService();
                mapService.start(vertx, config());

                persistenceService = new PersistenceService();
                persistenceService.start(config());

                if (devMode) {
                    sampleData = new SampleData();
                    sampleData.create(
                        identityService,
                        contextBrokerService,
                        persistenceService
                    );
                }

                webService = new WebService(
                    identityService,
                    contextBrokerService,
                    mapService,
                    persistenceService
                );

                webService.start(vertx, config(), event -> {
                    if (event.succeeded()) {
                        blocking.complete();
                    } else {
                        blocking.fail(event.cause());
                    }
                });
            },
            result -> {
                if (result.succeeded()) {
                    startFuture.complete();
                } else {
                    startFuture.fail(result.cause());
                }
            }
        );
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        try {
            if (webService != null)
                webService.stop();
            if (persistenceService != null)
                persistenceService.stop();
            if (mapService != null)
                mapService.stop();
            if (contextBrokerService != null)
                contextBrokerService.stop();
            if (identityService != null)
                identityService.stop();
            stopFuture.complete();
        } catch (Exception ex) {
            stopFuture.fail(ex);
        }
    }
}