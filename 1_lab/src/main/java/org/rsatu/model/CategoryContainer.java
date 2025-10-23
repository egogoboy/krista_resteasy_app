package org.rsatu.model;

import java.util.HashMap;
import java.util.Map;

import org.rsatu.controller.categories.CategoryItemBO;

public class CategoryContainer {

    private HashMap<Long, CategoryItemBO> category;

    private Long id_counter;

    public CategoryContainer() {
        this.category = new HashMap<>();
        this.id_counter = 1l;
    }

    public Long addCategory(CategoryItemBO new_category) {
        this.category.put(id_counter, new_category);
        return id_counter++;
    }

    public CategoryItemBO getCategory(Long id) {
        return this.category.get(id);
    }

    public CategoryItemBO getCategory(String title) {
        for (Map.Entry<Long, CategoryItemBO> entry : this.category.entrySet()) {
            if (entry.getValue().getTitle().equals(title)) {
                return new CategoryItemBO(entry.getKey(), entry.getValue().getTitle());
            }
        }
        return null;
    }
}
