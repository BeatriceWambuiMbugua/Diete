package com.moringaschool.diete.ui;

import com.moringaschool.diete.models.Categories;
import com.moringaschool.diete.models.Meals;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
