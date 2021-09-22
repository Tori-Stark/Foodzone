package com.dataflair.fooddeliveryapp.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dataflair.fooddeliveryapp.MainActivity;
import com.dataflair.fooddeliveryapp.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText emailEditTxt, passwordEditTxt;
    Button signInButton;
    CheckBox rememberMe;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for changing status bar icon colors
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);

        //extract variables from layout file
        emailEditTxt = (EditText) findViewById(R.id.EmailEditTextLogin);
        passwordEditTxt = (EditText) findViewById(R.id.PasswordTextLogin);
        signInButton = (Button) findViewById(R.id.GoogleSignInBtn);
        signInButton.setOnClickListener(this);


    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.GoogleSignInBtn:
                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("users");
                mAuth = FirebaseAuth.getInstance();
                userLogIn();
                break;
        }
    }

    private void userLogIn() {
        String userEnteredEmail = emailEditTxt.getText().toString().trim();
        String userEnteredPassword = passwordEditTxt.getText().toString().trim();

        if(userEnteredEmail.isEmpty()){
            emailEditTxt.setError("Email is Required");
            emailEditTxt.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(userEnteredEmail).matches()){
            emailEditTxt.setError("Please Enter a Valid Email");
            emailEditTxt.requestFocus();
            return;
        }
        if(userEnteredPassword.isEmpty()){
            emailEditTxt.setError("Password is Required");
            emailEditTxt.requestFocus();
            return;
        }

        /*if(rememberMe.isChecked()){
        }*/


        mAuth.signInWithEmailAndPassword(userEnteredEmail,userEnteredPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //check if user is email verified
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if (user.isEmailVerified()){
                        //redirect to ViewProfile Activity

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));

                    }
                    else {
                        user.sendEmailVerification();
                        Toast.makeText(LoginActivity.this,"Check Your Email To Verify Your Account",Toast.LENGTH_LONG).show();

                    }
                }
                else {
                    Toast.makeText(LoginActivity.this,"Log In Failed. Please Check Your Credentials",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

//    public void forgotpassword(View view) {
//
//        switch (view.getId()){
//            case R.id.button_forgotpassword:
//                startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
//                break;
//        }
//
//    }

    public void Register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}

