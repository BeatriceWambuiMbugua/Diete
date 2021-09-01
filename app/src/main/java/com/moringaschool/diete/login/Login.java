package com.moringaschool.diete.login;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.diete.R;
import com.moringaschool.diete.ui.HomePage;


public class Login extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = Login.class.getSimpleName();


    Button callSignUp, login_btn;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout email, password;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        callSignUp = findViewById(R.id.signup_screen);
        image = findViewById(R.id.imageView);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(Login.this, HomePage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        };

        login_btn.setOnClickListener(this);

        callSignUp.setOnClickListener((view) -> {
            Intent intent = new Intent(Login.this, Signup.class);

            Pair[] pairs = new Pair[7];

            pairs[0] = new Pair<View, String>(image, "logo_image");
            pairs[1] = new Pair<View, String>(logoText, "logo_name");
            pairs[2] = new Pair<View, String>(sloganText, "slogan_name");
            pairs[3] = new Pair<View, String>(email, "username_tran");
            pairs[4] = new Pair<View, String>(password, "password_tran");
            pairs[5] = new Pair<View, String>(login_btn, "button_tran");
            pairs[6] = new Pair<View, String>(callSignUp, "login_signup_tran");


            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, callSignUp, String.valueOf(pairs));
            startActivity(intent, options.toBundle());
        });
    }

    @Override
    public void onClick(View view) {
        if (view == login_btn) {
            loginWithPassword();
        }
    }

    private void loginWithPassword() {
        String userEmail = email.getEditText().getText().toString().trim();
        String passWord = password.getEditText().getText().toString().trim();

        if (userEmail.equals("")) {
            email.setError("Please Enter Your Username");
            return;
        }
        if (passWord.equals("")) {
            password.setError("Password Cannot be Blank");
            return;
        }
        mAuth.signInWithEmailAndPassword(userEmail, passWord)
                .addOnCompleteListener(this, task -> {
                    Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "signInWithEmail", task.getException());
                        Toast.makeText(Login.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
