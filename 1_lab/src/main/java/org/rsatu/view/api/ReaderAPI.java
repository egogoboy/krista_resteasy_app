package org.rsatu.view.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.rsatu.view.App;
import org.rsatu.view.api.dto.ReaderNewsDTO;
import org.rsatu.view.api.dto.ReaderNewsListDTO;

@Path("/reader")
@Produces({ MediaType.APPLICATION_JSON })
public class ReaderAPI {

    @GET
    @Path("/news/all")
    public Response getAllNews() {
        List<ReaderNewsDTO> all_news = App.newsContainer.getAllNews();

        return Response.ok().entity(new ReaderNewsListDTO(all_news)).build();

    }

    @GET
    @Path("/news/sorted")
    public Response getSortedNews(@QueryParam("category") String category) {
        List<ReaderNewsDTO> all_news = App.newsContainer.getAllNews();

        List<ReaderNewsDTO> sorted = all_news.stream()
                .filter(news -> news.getCategory().getName().equals(category)).collect(Collectors.toList());

        System.out.println(sorted);

        return Response.ok()
                .entity(new ReaderNewsListDTO(sorted))
                .build();
    }

    @GET
    @Path("/news")
    public Response getNews(@QueryParam("id") Long id) {
        if (!App.newsContainer.isContain(id)) {
            return Response.serverError().entity("News with id = " + id + " doesn't exist").build();
        }

        ReaderNewsDTO returnDto = App.newsContainer.getNews(id);

        return Response.ok().entity(returnDto).build();
    }
}
