package org.rsatu.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.rsatu.controller.news.NewsItemBO;
import org.rsatu.view.App;

public class NewsContainer {

    private LinkedHashMap<Long, NewsItemBO> news;
    private Long id_counter;

    public NewsContainer() {
        this.news = new LinkedHashMap<>();
        id_counter = 1l;
    }

    public Long addNews(NewsItemBO news_item) {
        if (App.categoryContainer.getCategory(news_item.getCategory()) == null) {
            System.out.println("[DEBUG] category " + news_item.getCategory() + " doesn't exist");
            return 0l;
        }
        news_item.setId(id_counter);
        news.put(id_counter, news_item);

        return id_counter++;
    }

    public List<NewsItemBO> getAllNews() {
        ArrayList<NewsItemBO> output_news = new ArrayList<>(this.news.values());

        return output_news;
    }

    public NewsItemBO getNews(Long id) {
        if (news.get(id) == null) {
            return null;
        }

        return news.get(id);
    }

    public boolean isContain(Long id) {
        return this.news.containsKey(id);
    }
}
