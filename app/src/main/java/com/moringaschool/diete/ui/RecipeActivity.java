package com.moringaschool.diete.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.diete.R;
import com.moringaschool.diete.adapters.RecipeArrayAdapter;
import com.moringaschool.diete.models.Result;
import com.moringaschool.diete.models.SpoonacularRecipeSearchResponse;
import com.moringaschool.diete.network.SpoonacularApi;
import com.moringaschool.diete.network.SpoonacularClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.moringaschool.diete.Constants.SPOONACULAR_API_KEY;

public class RecipeActivity extends AppCompatActivity {
    private static final String TAG = RecipeActivity.class.getSimpleName();
    @BindView(R.id.introductionTextView) TextView mIntroductionTextView;
   @BindView(R.id.listView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String diet = intent.getStringExtra("diet");

        SpoonacularApi client = SpoonacularClient.getClient();

        Call<SpoonacularRecipeSearchResponse> call = client.getRecipes(diet, diet, diet, SPOONACULAR_API_KEY);

        call.enqueue(new Callback<SpoonacularRecipeSearchResponse>() {
            @Override
            public void onResponse(Call<SpoonacularRecipeSearchResponse> call, Response<SpoonacularRecipeSearchResponse> response) {
                Log.d(TAG, "onResponse");
                if (response.isSuccessful()) {
                    Log.d(TAG, "isSuccessful");
                    List<Result> recipesList = response.body().getResults();
                    String[] recipes = new String[recipesList.size()];
                    String[] fats = new String[recipesList.size()];
                    for (int i = 0; i < recipes.length; i++) {
                        recipes[i] = recipesList.get(i).getTitle();
                        fats[i]= recipesList.get(i).getCarbs();
                    }


                    ArrayAdapter adapter = new RecipeArrayAdapter(RecipeActivity.this, android.R.layout.simple_list_item_1, recipes, fats);
                    mListView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<SpoonacularRecipeSearchResponse> call, Throwable t) {

            }

        });

    }
}