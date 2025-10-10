package org.rsatu.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class NewsContainer {

    private LinkedHashMap<Integer, String> news;
    private int id_counter;

    public NewsContainer() {
        this.news = new LinkedHashMap<>();
        id_counter = 1;
    }

    public void addNews(String title) {
        news.put(id_counter, title);
        id_counter++;
    }

    public String getAllNews() {
        List<String> output_news = new ArrayList<>(this.news.values());
        String output = "";

        for (String title : output_news) {
            output = output + title + ", ";
        }

        return output;
    }

    public String getNews(int id) {
        if (news.get(id) == null) {
            return "Unknown";
        }

        return news.get(id);
    }

    public boolean isContain(int id) {
        return this.news.containsKey(id);
    }
}
