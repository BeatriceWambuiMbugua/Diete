package com.moringaschool.diete;


import com.moringaschool.diete.network.FoodApi;
import com.moringaschool.diete.network.FoodClient;

public class Constants {
public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
public static FoodApi getApi(){
    return FoodClient.getFoodClient().create(FoodApi.class);
}
}
