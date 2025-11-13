package org.rsatu.controller.news;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.rsatu.view.App;

public class NewsController implements NewsInterface {
    public NewsController() {
    }

    public List<NewsItemBO> getAllNews() {
        List<NewsItemBO> news = App.newsDAO.getAllNews();
        if (news == null) {
            return new ArrayList<NewsItemBO>();
        }

        return news;
    }

    public List<NewsItemBO> getFilteredNews(String category) {
        return getAllNews().stream().filter(news -> news.getCategory().getTitle().equals(category))
                .collect(Collectors.toList());
    }

    public NewsItemBO getCurrentNews(Long id) {
        return App.newsDAO.getCurrentNews(id);
    }

    public NewsItemBO addNews(NewsItemBO news) {
        return App.newsDAO.addNews(news);
    }
}
