package org.rsatu.view.api.dto;

public class CategoryDTO {
    Long id;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(String name) {
        this.id = 0l;
        this.name = name;
    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String new_name) {
        this.name = new_name;
    }

    public String getName() {
        return this.name;
    }
}
