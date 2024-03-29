package com.moringaschool.diete.detail;

import com.moringaschool.diete.Constants;
import com.moringaschool.diete.models.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMain {
    private DetailView view;

    public DetailMain(DetailView view) {
        this.view = view;
    }

    void getMealById(String mealName) {
        view.showLoading();

        Constants.getApi().getMealByName(mealName)
                .enqueue(new Callback<Meals>() {
                    @Override
                    public void onResponse(Call<Meals> call, Response<Meals> response) {
                        view.hideLoading();
                        if (response.isSuccessful() && response.body() != null) {
                            view.setMeal(response.body().getMeals().get(0));
                        } else {
                            view.onErrorLoading(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<Meals> call, Throwable t) {
                        view.hideLoading();
                        view.onErrorLoading(t.getLocalizedMessage());
                    }
                });
    }
}
