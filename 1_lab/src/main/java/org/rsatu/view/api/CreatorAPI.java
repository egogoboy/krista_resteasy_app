package org.rsatu.view.api;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.rsatu.view.App;
import org.rsatu.view.api.dto.CreatorNewsDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

@Path("/creator")
public class CreatorAPI {

    @POST
    @Path("/news/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNews(CreatorNewsDTO news) {
        return Response.ok().entity(App.facadeController.addNews(news)).build();
    }
}
