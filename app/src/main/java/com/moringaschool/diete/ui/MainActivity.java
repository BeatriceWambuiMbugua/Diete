package com.moringaschool.diete.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.diete.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView appname;
    EditText introduction;


    @BindView (R.id.getRecipeButton) Button mGetRecipeButton;
    @BindView(R.id.introductionEditText) EditText mIntroductionEditText;
    @BindView (R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,  R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,  R.anim.bottom_animation);

        image = findViewById(R.id.imageView);
        appname = findViewById(R.id.appNameTextView);
        introduction = findViewById(R.id.introductionEditText);

        image.setAnimation(topAnim);
        appname.setAnimation(topAnim);
        introduction.setAnimation(bottomAnim);

        mGetRecipeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mGetRecipeButton){
            String introduction = mIntroductionEditText.getText().toString();
            Toast.makeText(MainActivity.this, "Welcome to Diete", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, HomePage.class);
            intent.putExtra("introduction", introduction);
            startActivity(intent);

        }
    }
}