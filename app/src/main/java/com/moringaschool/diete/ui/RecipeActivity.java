package com.moringaschool.diete.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.diete.R;
import com.moringaschool.diete.adapters.RecipeArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeActivity extends AppCompatActivity {
    @BindView(R.id.introductionTextView) TextView mIntroductionTextView;
   @BindView(R.id.listView) ListView mListView;

    private String[] recipes = new String[]{"Chicken Stew", "Bacon and Spinach", "Air Fryer Pork Chops", "Brocolli Beef",
    "Easy Chicken Fajitas", "Baked Spaghetti", "Garlicky Spaghetti", "Turkey Casserole", "Air Fryer Shrimp", "Lemon Pepper Chicken", "Beef Totchos", "Pinneapple Baked Chicken",
    "Slow Cooker Chicken Thighs", "Spaghetti and Meatballs"};
    private String[] cookings = new String[]{"10 minutes", "5 minutes", "20 minutes", "30 minutes", "20 minutes", "15 minutes", "20 minutes", "40 minutes",
            "10 minutes", "5 minutes", "20 minutes", "30 minutes", "20 minutes", "15 minutes", "20 minutes", "40 minutes",
            "10 minutes", "5 minutes", "20 minutes", "30 minutes", "20 minutes", "15 minutes", "20 minutes", "40 minutes"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);
        
        RecipeArrayAdapter adapter = new RecipeArrayAdapter(this, android.R.layout.simple_list_item_1, recipes, cookings);
        mListView.setAdapter(adapter);
        
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String recipe = ((TextView)view).getText().toString();
                Toast.makeText(RecipeActivity.this, recipe, Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        String introduction = intent.getStringExtra("introduction");
        mIntroductionTextView.setText("Here are the available Recipes for: " + introduction);
    }
}