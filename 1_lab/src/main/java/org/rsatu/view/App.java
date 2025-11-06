package org.rsatu.view;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.rsatu.controller.FacadeController;
import org.rsatu.model.CategoryContainer;
import org.rsatu.model.NewsContainer;
import org.rsatu.model.DAO.CategoryDAO;
import org.rsatu.model.DAO.NewsDAO;
import org.rsatu.view.api.SingletonAPI;

import io.undertow.Undertow;

public class App {

    public static NewsContainer newsContainer = new NewsContainer();
    public static CategoryContainer categoryContainer = new CategoryContainer();
    public static FacadeController facadeController = new FacadeController();

    public static CategoryDAO categoryDAO = new CategoryDAO();
    public static NewsDAO newsDAO = new NewsDAO();

    public static void main(String[] args) {
        try {
            Undertow.Builder builder = Undertow.builder().addHttpListener(8080, "0.0.0.0");
            UndertowJaxrsServer server = new UndertowJaxrsServer().start(builder);

            server.deploy(SingletonAPI.class);
            System.out.println("[SERVER] started. Listening on http://localhost:8080");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
