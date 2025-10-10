package org.rsatu.view.api;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.rsatu.view.App;

import javax.ws.rs.POST;

@Path("/creator")
public class CreatorAPI {

    @POST
    @Path("/news/create")
    public Response createNews(@QueryParam("title") String title) {
        App.newsContainer.addNews(title);

        return Response.ok().entity("Created news with title: " + title).build();
    }

}
