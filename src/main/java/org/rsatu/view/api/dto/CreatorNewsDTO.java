package org.rsatu.view.api.dto;

public class CreatorNewsDTO {
    private String title;
    private String text;
    private CategoryDTO category;

    public CreatorNewsDTO(String title, String description, String text, CategoryDTO category) {
        this.title = title;
        this.text = text;
        this.category = category;
    }

    public CreatorNewsDTO(CreatorNewsDTO news) {
        this.title = news.title;
        this.text = news.text;
        this.category = news.category;
    }

    public CreatorNewsDTO() {
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

    public String getText() {
        return this.text;
    }

    public CategoryDTO getCategory() {
        return this.category;
    }

}
