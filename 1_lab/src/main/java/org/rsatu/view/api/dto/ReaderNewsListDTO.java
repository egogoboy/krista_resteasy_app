package org.rsatu.view.api.dto;

import java.util.ArrayList;
import java.util.List;

import org.rsatu.controller.news.NewsItemBO;

public class ReaderNewsListDTO {
    private ArrayList<ReaderNewsDTO> news;

    public ReaderNewsListDTO(ArrayList<ReaderNewsDTO> other_news) {
        this.news = new ArrayList<>(other_news);
    }

    public ReaderNewsListDTO(List<NewsItemBO> other_news) {
        this.news = new ArrayList<>();
        for (NewsItemBO item : other_news) {
            this.news.add(new ReaderNewsDTO(item));
        }
    }

    public ReaderNewsListDTO() {
    }

    public ArrayList<ReaderNewsDTO> getNews() {
        return new ArrayList<>(news);
    }

    public void setNews(List<ReaderNewsDTO> other_news) {
        this.news = new ArrayList<>(other_news);
    }

}
