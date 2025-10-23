package org.rsatu.view.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.rsatu.view.App;
import org.rsatu.view.api.dto.CategoryDTO;
import org.rsatu.view.api.dto.ReaderNewsDTO;

@Path("/reader")
@Produces({ MediaType.APPLICATION_JSON })
public class ReaderAPI {

    @GET
    @Path("/news/all")
    public Response getAllNews() {
        return Response.ok().entity(App.facadeController.getAllNews()).build();
    }

    @GET
    @Path("/news/sorted")
    public Response getSortedNews(@QueryParam("category") String category) {
        return Response.ok()
                .entity(App.facadeController.getFilteredNews(new CategoryDTO(category)))
                .build();
    }

    @GET
    @Path("/news")
    public Response getNews(@QueryParam("id") Long id) {
        ReaderNewsDTO news = App.facadeController.getCurrentNews(id);
        if (news == null) {
            return Response.serverError().entity("News with id = " + id + " doesn't exist").build();
        }

        return Response.ok().entity(news).build();
    }
}
