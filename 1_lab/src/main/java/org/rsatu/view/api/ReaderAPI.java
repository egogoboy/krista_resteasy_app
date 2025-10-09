package org.rsatu.view.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/reader")
public class ReaderAPI {

    @GET
    @Path("/news/all")
    public Response getAllNews() {
        return Response.ok().entity("All news").build();
    }

    @GET
    @Path("/news")
    public Response getAllNews(@QueryParam("id") int id) {
        return Response.ok().entity("News with id: " + id).build();
    }

    @GET
    @Path("/like")
    public Response likeNews(@QueryParam("id") int id, @QueryParam("rate") int rate) {
        if (rate < 0 || rate > 10) {
            return Response.serverError().entity("Invalid rate").build();
        }

        return Response.ok().entity("Rated news " + id + ". Rate: " + rate).build();
    }
}
