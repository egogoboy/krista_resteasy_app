package org.rsatu.view.api.dto;

import java.util.ArrayList;
import java.util.List;

public class ReaderNewsListDTO {
    private ArrayList<ReaderNewsDTO> news;

    public ReaderNewsListDTO(List<ReaderNewsDTO> other_news) {
        this.news = new ArrayList<>(other_news);
        System.out.println(other_news);
        System.out.println(this.news);
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
