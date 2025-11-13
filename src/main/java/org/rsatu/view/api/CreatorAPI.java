package org.rsatu.view.api;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.rsatu.view.App;
import org.rsatu.view.api.dto.CategoryDTO;
import org.rsatu.view.api.dto.CreatorNewsDTO;
import org.rsatu.view.api.dto.ReaderNewsDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

@Path("/creator")
public class CreatorAPI {

    @POST
    @Path("/news/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNews(CreatorNewsDTO news) {
        ReaderNewsDTO result = App.facadeController.addNews(news);
        if (result == null) {
            return Response.status(500).entity("Error while adding news").build();
        }
        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/categories/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCategory(CategoryDTO category) {
        return Response.ok().entity(App.facadeController.addCategory(category)).build();
    }
}
