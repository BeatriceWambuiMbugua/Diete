package com.moringaschool.diete.network;

import com.moringaschool.diete.SpoonacularRecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpoonacularApi {

        @GET("recipes/complexSearch")
        Call<SpoonacularRecipeSearchResponse> getRestaurants(
                @Query("diet") String diet,
                @Query("cuisine") String cuisine
        );
}
