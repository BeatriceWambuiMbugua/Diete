package com.moringaschool.diete.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.diete.Constants.SPOONACULAR_API_KEY;
import static com.moringaschool.diete.Constants.SPOONACULAR_BASE_URL;

public class SpoonacularClient {
    private static Retrofit retrofit = null;

    public static SpoonacularApi getClient(){
        if (retrofit == null){
            Interceptor interceptor;
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("Authorization", SPOONACULAR_API_KEY)
                            .build();
                    return chain.proceed(newRequest);
                }
            })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(SPOONACULAR_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(SpoonacularApi.class);
    }
}
