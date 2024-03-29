package com.moringaschool.diete.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.diete.R;
import com.moringaschool.diete.login.Login;

import android.os.Handler;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView appnameview;
    TextView appname;
    private static int SPLASH_SCREEN = 5000;


    @BindView(R.id.appName)
    EditText mAppName;
    @BindView(R.id.appNameTextView)
    TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.imageView);
        appnameview = findViewById(R.id.appNameTextView);
        appname = findViewById(R.id.appName);


        image.setAnimation(topAnim);
        appname.setAnimation(topAnim);
        appnameview.setAnimation(bottomAnim);


        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, Login.class);
            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<View, String>(image, "food_image");
            pairs[1] = new Pair<View, String>(appname, "app_name");
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
            startActivity(intent, options.toBundle());


        }, SPLASH_SCREEN);

    }

}