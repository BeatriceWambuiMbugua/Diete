package com.moringaschool.diete.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.moringaschool.diete.Constants;
import com.moringaschool.diete.R;
import com.moringaschool.diete.adapters.RecipeArrayAdapter;
import com.moringaschool.diete.models.Categories;
import com.moringaschool.diete.models.Meals;
import com.moringaschool.diete.network.FoodApi;
import com.moringaschool.diete.network.FoodClient;
//import com.moringaschool.diete.models.Result;
//import com.moringaschool.diete.models.SpoonacularRecipeSearchResponse;
//import com.moringaschool.diete.network.SpoonacularApi;
//import com.moringaschool.diete.network.SpoonacularClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.internal.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class RecipeActivity extends AppCompatActivity {


    private HomeView view;

    public RecipeActivity(HomeView view) {
        this.view = view;
    }

    void getMeals() {
        view.showLoading();

        Call<Meals> mealsCall = Constants.getApi().getMeal();
        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(@NonNull Call<Meals> call, @NonNull Response<Meals> response) {
                view.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    view.setMeal(response.body().getMeals());

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

    void getCategories() {
        view.showLoading();

        Call<Categories> categoriesCall = Constants.getApi().getCategories();
        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(@NonNull Call<Categories> call, @NonNull Response<Categories> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.setCategory(response.body().getCategories());
                } else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }


}
