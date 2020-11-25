package com.moringaschool.diete.network;

import com.moringaschool.diete.models.SpoonacularRecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpoonacularApi {

        @GET("complexSearch")
        Call<SpoonacularRecipeSearchResponse> getRecipes(
                @Query("query") String query,
               @Query("diet") String diet,
               @Query("cuisine") String cuisine,
                @Query("apiKey") String apiKey
        );
}
