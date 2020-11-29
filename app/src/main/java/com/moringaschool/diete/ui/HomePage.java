package com.moringaschool.diete.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.moringaschool.diete.R;
import com.moringaschool.diete.models.Categories;
import com.moringaschool.diete.models.Meals;

import java.util.List;

import butterknife.ButterKnife;

public class HomePage extends AppCompatActivity implements HomeView {

    RecipeActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);

        activity = new RecipeActivity(this);
        activity.getMeals();
        activity.getCategories();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void setMeal(List<Meals.Meal> meal) {
        for(Meals.Meal mealresult : meal){
            Log.w("meal name: ", mealresult.getStrMeal());
        }
    }

    @Override
    public void setCategory(List<Categories.Category> category) {

    }

    @Override
    public void onErrorLoading(String message) {

    }
}