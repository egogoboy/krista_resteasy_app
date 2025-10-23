package org.rsatu.controller.news;

import java.util.Date;

import org.rsatu.view.api.dto.CreatorNewsDTO;

public class NewsItemBO {
    private Long id;
    private String title;
    private String text;
    private String image;
    private String category;
    private Date publish_date;
    private Integer likes;

    public NewsItemBO() {
    }

    public NewsItemBO(
            Long id,
            String title,
            String text,
            String image,
            String category,
            Date publish_date,
            Integer likes) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.image = image;
        this.category = category;
        this.publish_date = publish_date;
        this.likes = likes;
    }

    public NewsItemBO(Long id, CreatorNewsDTO news) {
        this.id = id;
        this.title = news.getTitle();
        this.text = news.getText();
        // this.image = image;
        this.category = news.getCategory().getName();
        // this.publish_date = publish_date;
        this.likes = 0;
    }

    public void increaseLikes(Integer count) {
        this.likes += count;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String new_title) {
        this.title = new_title;
    }

    public void setText(String new_text) {
        this.text = new_text;
    }

    public void setImage(String new_image) {
        this.image = new_image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublishDate(Date date) {
        this.publish_date = date;
    }

    public void setLikes(Integer likes_count) {
        this.likes = likes_count;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.text;
    }

    public String getImage() {
        return this.image;
    }

    public String getCategory() {
        return this.category;
    }

    public Date getPublishDate() {
        return this.publish_date;
    }

    public Integer getLikesCount() {
        return this.likes;
    }
}
