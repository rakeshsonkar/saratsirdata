
package in.ifms.employee;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.spi.CDI;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.helidon.microprofile.server.Server;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MainTest {
    private static Server server;

    @BeforeAll
    public static void startTheServer() throws Exception {
        server = Server.create().start();
    }

    @Test
    void testHelloWorld() {
        Client client = ClientBuilder.newClient();

        JsonObject jsonObject = client
                .target(getConnectionString("/greet"))
                .request()
                .get(JsonObject.class);
        Assertions.assertEquals("Hello World!", jsonObject.getString("message"),
                "default message");

        jsonObject = client
                .target(getConnectionString("/greet/Joe"))
                .request()
                .get(JsonObject.class);
        Assertions.assertEquals("Hello Joe!", jsonObject.getString("message"),
                "hello Joe message");

        Response r = client
                .target(getConnectionString("/greet/greeting"))
                .request()
                .put(Entity.entity("{\"greeting\" : \"Hola\"}", MediaType.APPLICATION_JSON));
        Assertions.assertEquals(204, r.getStatus(), "PUT status code");

        jsonObject = client
                .target(getConnectionString("/greet/Jose"))
                .request()
                .get(JsonObject.class);
        Assertions.assertEquals("Hola Jose!", jsonObject.getString("message"),
                "hola Jose message");

        r = client
                .target(getConnectionString("/metrics"))
                .request()
                .get();
        Assertions.assertEquals(200, r.getStatus(), "GET metrics status code");

        r = client
                .target(getConnectionString("/health"))
                .request()
                .get();
        Assertions.assertEquals(200, r.getStatus(), "GET health status code");
    }

    @AfterAll
    static void destroyClass() {
        CDI<Object> current = CDI.current();
        ((SeContainer) current).close();
    }

    private String getConnectionString(String path) {
        return "http://localhost:" + server.port() + path;
    }
}
