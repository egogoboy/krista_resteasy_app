package org.rsatu.model;

import java.util.LinkedHashMap;

public class NewsContainer {

    private LinkedHashMap<Integer, String> news;

    public void addNews(int id, String title) {
        news.put(id, title);
    }

    public String getAllNews() {
        return "All news";
    }

    public String getNews(int id) {
        if (news.get(id) == null) {
            return "Unknown"; 
        }

        return news.get(id);
    }
}
