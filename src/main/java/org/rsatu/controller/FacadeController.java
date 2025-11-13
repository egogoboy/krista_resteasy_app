package org.rsatu.controller;

import java.util.ArrayList;
import java.util.List;

import org.rsatu.controller.categories.CategoriesController;
import org.rsatu.controller.categories.CategoryItemBO;
import org.rsatu.controller.news.NewsController;
import org.rsatu.controller.news.NewsInterface;
import org.rsatu.controller.news.NewsItemBO;
import org.rsatu.controller.news.decor.PositiveNewsDecorator;
import org.rsatu.view.api.dto.*;

public class FacadeController {

    private NewsInterface newsController;
    private CategoriesController categoriesController;
    private boolean autumn;

    public FacadeController() {
        this.autumn = true;
        if (this.autumn) {
            this.newsController = new PositiveNewsDecorator(new NewsController());
        } else {
            this.newsController = new NewsController();
        }

        this.categoriesController = new CategoriesController();
    }

    public List<ReaderNewsDTO> getAllNews() {
        return NewsBOListParser(newsController.getAllNews());
    }

    public List<ReaderNewsDTO> getFilteredNews(CategoryDTO category) {
        return NewsBOListParser(newsController.getFilteredNews(category.getName()));
    }

    public ReaderNewsDTO getCurrentNews(Long id) {
        return NewsBOtoDTO(newsController.getCurrentNews(id));
    }

    public ReaderNewsDTO addNews(CreatorNewsDTO news) {
        return NewsBOtoDTO(newsController.addNews(NewsDTOtoBO(news)));
    }

    public CategoryDTO addCategory(CategoryDTO category) {
        return CategoryBOToDTO(categoriesController.addCategory(CategoryDTOToBO(category)));
    }

    public CategoryDTO getCategory(CategoryDTO category) {
        return CategoryBOToDTO(categoriesController.getCategory(CategoryDTOToBO(category)));
    }

    private ReaderNewsDTO NewsBOtoDTO(NewsItemBO news) {
        if (news == null) {
            return null;
        }

        ReaderNewsDTO result = new ReaderNewsDTO();
        CategoryItemBO news_category = news.getCategory();

        result.setId(news.getId());
        result.setText(news.getText());
        result.setTitle(news.getTitle());
        result.setCategory(
                new CategoryDTO(news_category.getId(), news_category.getTitle()));

        return result;
    }

    private NewsItemBO NewsDTOtoBO(CreatorNewsDTO news) {
        NewsItemBO result = new NewsItemBO();
        CategoryDTO news_category = news.getCategory();

        result.setTitle(news.getTitle());
        result.setCategory(new CategoryItemBO(news_category.getId(), news_category.getName()));
        result.setText(news.getText());

        return result;
    }

    private CategoryDTO CategoryBOToDTO(CategoryItemBO category) {
        if (category == null) {
            return new CategoryDTO(-1l, "null");
        }
        return new CategoryDTO(category.getId(), category.getTitle());
    }

    private CategoryItemBO CategoryDTOToBO(CategoryDTO category) {
        return new CategoryItemBO(0l, category.getName());
    }

    private List<ReaderNewsDTO> NewsBOListParser(List<NewsItemBO> news) {
        if (news == null) {
            return null;
        }

        List<ReaderNewsDTO> result = new ArrayList<>();
        for (NewsItemBO item : news) {
            result.add(NewsBOtoDTO(item));
        }

        return result;
    }
}
