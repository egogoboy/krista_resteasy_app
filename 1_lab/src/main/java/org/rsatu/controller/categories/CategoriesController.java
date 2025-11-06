package org.rsatu.controller.categories;

import org.rsatu.view.App;

public class CategoriesController {
    public CategoriesController() {
    }

    public CategoryItemBO addCategory(CategoryItemBO category) {
        return App.categoryDAO.addCategory(category);
    }

    public CategoryItemBO getCategory(CategoryItemBO category) {
        return App.categoryContainer.getCategory(category.getTitle());
    }
}
