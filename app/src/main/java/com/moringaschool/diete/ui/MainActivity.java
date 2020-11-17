package com.moringaschool.diete.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.diete.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView (R.id.getRecipeButton) Button mGetRecipeButton;
    @BindView(R.id.introductionEditText) EditText mIntroductionEditText;
    @BindView (R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mGetRecipeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}