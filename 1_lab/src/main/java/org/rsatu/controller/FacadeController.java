package org.rsatu.controller;

import java.util.ArrayList;
import java.util.List;

import org.rsatu.controller.categories.CategoriesController;
import org.rsatu.controller.categories.CategoryItemBO;
import org.rsatu.controller.news.NewsController;
import org.rsatu.controller.news.NewsItemBO;
import org.rsatu.view.api.dto.*;

public class FacadeController {

    private NewsController newsController;
    private CategoriesController categoriesController;

    private List<ReaderNewsDTO> NewsBOListParser(List<NewsItemBO> news) {
        List<ReaderNewsDTO> result = new ArrayList<>();
        for (NewsItemBO item : news) {
            result.add(NewsBOtoDTO(item));
        }

        return result;
    }

    public FacadeController() {
        this.newsController = new NewsController();
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
        Long id = newsController.addNews(NewsDTOtoBO(news));

        return NewsBOtoDTO(newsController.getCurrentNews(id));
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

        result.setId(news.getId());
        result.setText(news.getText());
        result.setTitle(news.getTitle());
        result.setCategory(new CategoryDTO(news.getCategory()));

        return result;
    }

    private NewsItemBO NewsDTOtoBO(CreatorNewsDTO news) {
        NewsItemBO result = new NewsItemBO();

        result.setTitle(news.getTitle());
        result.setCategory(news.getCategory().getName());
        result.setText(news.getText());

        return result;
    }

    private CategoryDTO CategoryBOToDTO(CategoryItemBO category) {
        return new CategoryDTO(category.getTitle());
    }

    private CategoryItemBO CategoryDTOToBO(CategoryDTO category) {
        return new CategoryItemBO(0l, category.getName());
    }

}
