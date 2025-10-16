package org.rsatu.view.api.dto;

public class ReaderNewsDTO extends CreatorNewsDTO {
    private Long id;

    public ReaderNewsDTO(Long id, String title, String description, String text, CategoryDTO category) {
        super(title, description, text, category);
        this.id = id;
    }

    public ReaderNewsDTO(Long id, CreatorNewsDTO creator_news) {
        super(creator_news);
        this.id = id;
    }

    public ReaderNewsDTO() {
    }

    public void setId(Long new_id) {
        this.id = new_id;
    }

    public Long getId() {
        return this.id;
    }
}
