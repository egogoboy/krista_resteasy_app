package org.rsatu.view.api.dto;

import org.rsatu.controller.news.NewsItemBO;

public class CreatorNewsDTO {
    private String title;
    private String description;
    private String text;
    private CategoryDTO category;

    public CreatorNewsDTO(String title, String description, String text, CategoryDTO category) {
        this.title = title;
        this.description = description;
        this.text = text;
        this.category = category;
    }

    public CreatorNewsDTO(CreatorNewsDTO news) {
        this.title = news.title;
        this.description = news.description;
        this.text = news.text;
        this.category = news.category;
    }

    public CreatorNewsDTO(NewsItemBO news) {
        this.title = news.getTitle();
        this.text = news.getText();
        this.category = new CategoryDTO(news.getCategory());
    }

    public CreatorNewsDTO() {
    }

    public void setDescription(String new_description) {
        this.description = new_description;
    }

    public void setTitle(String new_title) {
        this.title = new_title;
    }

    public void setText(String new_text) {
        this.text = new_text;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getText() {
        return this.text;
    }

    public CategoryDTO getCategory() {
        return this.category;
    }

}
