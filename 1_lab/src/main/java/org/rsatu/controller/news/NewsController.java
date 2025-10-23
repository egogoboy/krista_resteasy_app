package org.rsatu.controller.news;

import java.util.List;
import java.util.stream.Collectors;

import org.rsatu.view.App;

public class NewsController {
    public NewsController() {
    }

    public List<NewsItemBO> getAllNews() {
        return App.newsContainer.getAllNews();
    }

    public List<NewsItemBO> getFilteredNews(String category) {
        return getAllNews().stream().filter(news -> news.getCategory().equals(category)).collect(Collectors.toList());
    }

    public NewsItemBO getCurrentNews(Long id) {
        return App.newsContainer.getNews(id);
    }

    public Long addNews(NewsItemBO news) {
        return App.newsContainer.addNews(news);
    }
}
