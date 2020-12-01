package com.moringaschool.diete.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.moringaschool.diete.R;

public class Signup extends AppCompatActivity {
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);
        login_btn = findViewById(R.id.login_btn);

        login_btn.setOnClickListener(v -> {
            Intent intent = new Intent (Signup.this, HomePage.class);
            startActivity(intent);
        });


    }
}