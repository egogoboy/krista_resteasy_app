package org.rsatu.view;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.rsatu.view.api.SingletonAPI;

import io.undertow.Undertow;

public class App {
    public static void main( String[] args ) {
        try {
            Undertow.Builder builder = Undertow.builder().addHttpListener(8080, "localhost");
            UndertowJaxrsServer server = new UndertowJaxrsServer().start(builder);
 
            server.deploy(SingletonAPI.class);
            System.out.println("[SERVER] started. Listen on http://localhost:8080");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
