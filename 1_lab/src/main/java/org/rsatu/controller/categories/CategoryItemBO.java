package org.rsatu.controller.categories;

public class CategoryItemBO {
    private Long id;
    private String title;

    public CategoryItemBO() {
        this.id = 0l;
        this.title = "";
    }

    public CategoryItemBO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String new_title) {
        this.title = new_title;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
}
