package org.rsatu.view.api.dto;

public class CategoryDTO {
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(String name) {
        this.name = name;
    }

    public void setName(String new_name) {
        this.name = new_name;
    }

    public String getName() {
        return this.name;
    }
}
