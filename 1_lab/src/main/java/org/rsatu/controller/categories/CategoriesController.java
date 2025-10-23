package org.rsatu.controller.categories;

import org.rsatu.view.App;

public class CategoriesController {
    public CategoriesController() {
    }

    public CategoryItemBO addCategory(CategoryItemBO category) {
        Long id = App.categoryContainer.addCategory(category);

        return App.categoryContainer.getCategory(id);
    }

    public CategoryItemBO getCategory(CategoryItemBO category) {
        return App.categoryContainer.getCategory(category.getTitle());
    }
}
