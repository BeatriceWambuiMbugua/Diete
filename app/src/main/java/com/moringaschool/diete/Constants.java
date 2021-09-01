package com.moringaschool.diete;


import android.app.AlertDialog;
import android.content.Context;

import com.moringaschool.diete.network.FoodApi;
import com.moringaschool.diete.network.FoodClient;

public class Constants {
    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    public static FoodApi getApi() {
        return FoodClient.getFoodClient().create(FoodApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}
