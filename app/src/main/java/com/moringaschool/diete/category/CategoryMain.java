package com.moringaschool.diete.category;

import androidx.annotation.NonNull;

import com.moringaschool.diete.Constants;
import com.moringaschool.diete.models.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryMain {
    private CategoryView view;

    public CategoryMain(CategoryView view){
        this.view = view;
    }
    void getMealByCategory(String category){
        view.showLoading();
        Call<Meals> mealsCall = Constants.getApi().getMealByCategory(category);
        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(@NonNull Call<Meals> call, @NonNull Response<Meals> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null){
                    view.setMeals(response.body().getMeals());
                } else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Meals> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());

            }
        });
    }
}
