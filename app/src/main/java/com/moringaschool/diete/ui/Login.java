package com.moringaschool.diete.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.moringaschool.diete.R;


public class Login extends AppCompatActivity {

    Button callSignUp, login_btn;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        callSignUp = findViewById(R.id.signup_screen);
        image = findViewById(R.id.imageView);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);

        login_btn.setOnClickListener(v -> {
            Intent intent = new Intent (Login.this, HomePage.class);
            startActivity(intent);
        });

        callSignUp.setOnClickListener((view) ->{
            Intent intent = new Intent(Login.this, Signup.class);

            Pair[] pairs = new Pair[7];

            pairs[0] = new Pair<View, String>(image, "logo_image");
            pairs[1] = new Pair<View, String>(logoText, "logo_name");
            pairs[2] = new Pair<View, String>(sloganText, "slogan_name");
            pairs[3] = new Pair<View, String>(username, "username_tran");
            pairs[4] = new Pair<View, String>(password, "password_tran");
            pairs[5] = new Pair<View, String>(login_btn, "button_tran");
            pairs[6] = new Pair<View, String>(callSignUp, "login_signup_tran");



          ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, callSignUp, String.valueOf(pairs));
            startActivity(intent, options.toBundle());
        });
    }
}