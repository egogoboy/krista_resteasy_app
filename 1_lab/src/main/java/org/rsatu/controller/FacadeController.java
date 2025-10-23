package org.rsatu.controller;

import org.rsatu.controller.news.NewsController;
import org.rsatu.controller.news.NewsItemBO;
import org.rsatu.view.api.dto.*;

public class FacadeController {

    private NewsController newsController;

    public FacadeController() {
        this.newsController = new NewsController();
    }

    public ReaderNewsListDTO getAllNews() {
        return new ReaderNewsListDTO(newsController.getAllNews());
    }

    public ReaderNewsListDTO getFilteredNews(String category) {
        return new ReaderNewsListDTO(newsController.getFilteredNews(category));
    }

    public ReaderNewsDTO getCurrentNews(Long id) {
        return new ReaderNewsDTO(newsController.getCurrentNews(id));
    }

    public ReaderNewsDTO addNews(CreatorNewsDTO news) {
        Long id = newsController.addNews(new NewsItemBO(0l, news));

        return new ReaderNewsDTO(newsController.getCurrentNews(id));
    }

}
