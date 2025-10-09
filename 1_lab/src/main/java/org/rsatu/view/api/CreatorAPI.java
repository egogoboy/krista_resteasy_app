package org.rsatu.view.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/creator")
public class CreatorAPI {
    
    @GET
    @Path("/news/create")
    public Response createNews(@QueryParam("title") String title) {
        return Response.ok().entity("Created news with title: " + title).build();
    }
}
