package com.moringaschool.diete.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.moringaschool.diete.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeActivity extends AppCompatActivity {
    @BindView(R.id.introductionTextView) TextView mIntroductionTextView;
   // @BindView(R.id.listView) ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String introduction = intent.getStringExtra("introduction");
        mIntroductionTextView.setText("Here are the available Recipes for: " + introduction);
    }
}