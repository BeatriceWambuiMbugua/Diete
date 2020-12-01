package com.moringaschool.diete.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.diete.R;

public class Signup extends AppCompatActivity {
    Button login_btn, regtologinbtn;
    TextInputLayout regname, regusername, regpassword, regemail, regphoneNumber;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);


        regname = findViewById(R.id.reg_name);
        login_btn = findViewById(R.id.login_btn);
        regemail = findViewById(R.id.reg_email);
        regusername = findViewById(R.id.reg_username);
        regpassword = findViewById(R.id.reg_password);
        regphoneNumber = findViewById(R.id.reg_phoneNumber);
        regtologinbtn = findViewById(R.id.reg_tologinbtn);

        login_btn.setOnClickListener(v -> {
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("users");
            reference.setValue("First data");
            Intent intent = new Intent (Signup.this, HomePage.class);
            startActivity(intent);
        });


    }
}