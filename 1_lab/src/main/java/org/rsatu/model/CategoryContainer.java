package org.rsatu.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.rsatu.view.api.dto.CategoryDTO;
import org.rsatu.view.api.dto.CreatorNewsDTO;
import org.rsatu.view.api.dto.ReaderNewsDTO;

public class CategoryContainer {

    private ArrayList<CategoryDTO> category;

    public CategoryContainer() {
        this.category = new ArrayList<>();
    }

    public void addCategory(CategoryDTO new_category) {
        this.category.add(new_category);
    }
}
