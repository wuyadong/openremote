package org.openremote.manager.test;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.TestContext;
import org.openremote.manager.server.ServerVerticle;
import org.openremote.manager.server.service.WebService;

import java.net.Inet4Address;
import java.net.ServerSocket;

public abstract class ServerTest extends IntegrationTest {

    protected int ephemeralPort;

    @Override
    public void setUp(TestContext context) {
        super.setUp(context);

        this.ephemeralPort = findEphemeralPort();

        DeploymentOptions options = new DeploymentOptions().setConfig(
            new JsonObject().put(WebService.WEB_SERVER_PORT, ephemeralPort)
        );

        vertx.deployVerticle(
            ServerVerticle.class.getName(),
            options,
            context.asyncAssertSuccess()
        );
    }

    protected Integer findEphemeralPort() {
        try {
            ServerSocket socket = new ServerSocket(0, 0, Inet4Address.getLocalHost());
            int port = socket.getLocalPort();
            socket.close();
            return port;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
