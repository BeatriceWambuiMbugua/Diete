package com.moringaschool.diete.network;

import com.moringaschool.diete.models.Categories;
import com.moringaschool.diete.models.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodApi {
    @GET ("search.php")
    Call<Meals> getMeal();
    @GET ("search.php")
    Call<Meals> getMealByName(@Query("s") String mealName);
    @GET ("categories.php")
    Call<Categories>getCategories();
    @GET("filter.php")
    Call<Meals> getMealByCategory(@Query("c") String category);
}
