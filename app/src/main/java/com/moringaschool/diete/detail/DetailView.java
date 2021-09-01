package com.moringaschool.diete.detail;

import com.moringaschool.diete.models.Meals;

public interface DetailView {
    void showLoading();
    void hideLoading();
    void setMeal(Meals.Meal meal);
    void onErrorLoading(String message);
}
