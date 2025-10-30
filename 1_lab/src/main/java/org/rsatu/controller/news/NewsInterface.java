package org.rsatu.controller.news;

import java.util.List;

public interface NewsInterface {

    public List<NewsItemBO> getAllNews();

    public List<NewsItemBO> getFilteredNews(String category);

    public NewsItemBO getCurrentNews(Long id);

    public Long addNews(NewsItemBO news);
}
