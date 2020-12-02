package com.moringaschool.diete.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.diete.R;
import com.moringaschool.diete.ui.HomePage;

import java.lang.Boolean;

public class Signup extends AppCompatActivity {
    Button login_btn, regtologinbtn;
    TextInputLayout regname, regusername, regpassword, regemail, regphoneNumber;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    private Boolean validateName() {
        String val = regname.getEditText().getText().toString();
        if (val.isEmpty()){
            regname.setError("Field Cannot be empty");
            return false;
        } else {
            regname.setError(null);
            regname.setErrorEnabled(false);
            return true;
        }

    }
    private Boolean validateUsername() {
        String val = regusername.getEditText().getText().toString().trim();
        if (val.isEmpty()){
            regusername.setError("Field Cannot be empty");
            return false;
        } else if(val.length()>=15){
            regusername.setError("Username too long");
            return false;
        }
        else {
            regusername.setError(null);
            regusername.setErrorEnabled(false);
            return true;
        }

    }
    private Boolean validateEmail() {
        String val = regemail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()){
            regemail.setError("Field Cannot be empty");
            return false;
        } else if(!val.matches(emailPattern)){
            regemail.setError("Invalid Email Address");
            return false;

        }
        else {
            regemail.setError(null);
            regemail.setErrorEnabled(false);
            return true;
        }

    }
    private Boolean validatePhoneNumber() {
        String val = regphoneNumber.getEditText().getText().toString();
        if (val.isEmpty()){
            regphoneNumber.setError("Field Cannot be empty");
            return false;
        } else {
            regphoneNumber.setError(null);
            regphoneNumber.setErrorEnabled(false);
            return true;
        }

    }
    private Boolean validatePassword() {
        String val = regpassword.getEditText().getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if (val.isEmpty()){
            regpassword.setError("Field Cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            regpassword.setError("Password is too weak");
            return false;
        }
        else {
            regpassword.setError(null);
            regpassword.setErrorEnabled(false);
            return true;
        }

    }

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

            if(!validateName() | !validateUsername() | !validatePhoneNumber() | !validatePassword() | !validateEmail()){
                return;
            }
            String name = regname.getEditText().getText().toString();
            String username = regusername.getEditText().getText().toString();
            String email = regemail.getEditText().getText().toString();
            String phoneNumber = regphoneNumber.getEditText().getText().toString();
            String password = regpassword.getEditText().getText().toString();

            UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNumber, password);
            reference.child(phoneNumber).setValue(helperClass);

            Intent intent = new Intent (Signup.this, HomePage.class);
            startActivity(intent);
        });


    }
}