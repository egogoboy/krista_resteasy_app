package org.rsatu.controller.news.decor;

import java.util.List;

import org.rsatu.controller.news.NewsInterface;
import org.rsatu.controller.news.NewsItemBO;

public class PositiveNewsDecorator extends NewsDecorator {
    public PositiveNewsDecorator(NewsInterface newsController) {
        super(newsController);
    }

    @Override
    public List<NewsItemBO> getAllNews() {
        return getFilteredNews("positive");
    }

}
