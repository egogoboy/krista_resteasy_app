package org.rsatu.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.rsatu.view.api.dto.CreatorNewsDTO;
import org.rsatu.view.api.dto.ReaderNewsDTO;

public class NewsContainer {

    private LinkedHashMap<Long, ReaderNewsDTO> news;
    private Long id_counter;

    public NewsContainer() {
        this.news = new LinkedHashMap<>();
        id_counter = 1l;
    }

    public Long addNews(CreatorNewsDTO news_item) {
        news.put(id_counter, new ReaderNewsDTO(id_counter, news_item));

        return id_counter++;
    }

    public List<ReaderNewsDTO> getAllNews() {
        ArrayList<ReaderNewsDTO> output_news = new ArrayList<>(this.news.values());

        return output_news;
    }

    public ReaderNewsDTO getNews(Long id) {
        if (news.get(id) == null) {
            return new ReaderNewsDTO();
        }

        return news.get(id);
    }

    public boolean isContain(Long id) {
        return this.news.containsKey(id);
    }
}
