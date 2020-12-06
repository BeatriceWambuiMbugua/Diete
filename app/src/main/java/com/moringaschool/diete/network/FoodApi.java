package com.moringaschool.diete.network;

import com.moringaschool.diete.models.Categories;
import com.moringaschool.diete.models.Meals;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodApi {
    @GET ("search.php")
    Call<Meals> getMeal();
    @GET ("categories.php")
    Call<Categories>getCategories();
}
