package org.rsatu.controller.news.decor;

import java.util.List;

import org.rsatu.controller.news.NewsInterface;
import org.rsatu.controller.news.NewsItemBO;

public abstract class NewsDecorator implements NewsInterface {
    protected NewsInterface newsController;

    public NewsDecorator(NewsInterface newsController) {
        this.newsController = newsController;
    }

    @Override
    public List<NewsItemBO> getAllNews() {
        return newsController.getAllNews();
    }

    @Override
    public List<NewsItemBO> getFilteredNews(String category) {
        return newsController.getFilteredNews(category);
    }

    @Override
    public NewsItemBO getCurrentNews(Long id) {
        return newsController.getCurrentNews(id);
    }

    @Override
    public NewsItemBO addNews(NewsItemBO news) {
        return newsController.addNews(news);
    }

}
