package com.dataflair.fooddeliveryapp.Activities;

//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.dataflair.fooddeliveryapp.R;
//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.auth.api.signin.GoogleSignInClient;
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.common.api.ApiException;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthCredential;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.GoogleAuthProvider;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.annotations.NotNull;
//
//import java.util.HashMap;
//
//public class LoginActivity extends AppCompatActivity {
//
//    GoogleSignInClient mSignInClient;
//    FirebaseAuth firebaseAuth;
//    ProgressDialog progressBar;
//    Button signInButton;
//    EditText emailEditTxt, passwordEditTxt;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        //Firebase Authentication
//        firebaseAuth = FirebaseAuth.getInstance();
//
//        //Progress bar
//        progressBar = new ProgressDialog(this);
//        progressBar.setTitle("Please Wait...");
//        progressBar.setMessage("We are setting Everything for you...");
//        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//
//
//        //Assigning the address of the android materials
//        emailEditTxt = (EditText) findViewById(R.id.EmailEditTextLogin);
//        passwordEditTxt = (EditText) findViewById(R.id.PasswordTextLogin);
//        signInButton = (Button) findViewById(R.id.GoogleSignInBtn);
//
//
//        //Google Signin Options to get gmail and performa gmail login
//        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions
//                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken("319466083877-4cdnl01r8q8p84nqgtcp42tv8cn0dq12.apps.googleusercontent.com")
//                .requestEmail()
//                .build();
//
//        mSignInClient = GoogleSignIn.getClient(getApplicationContext(), googleSignInOptions);
//
//
//        //Implementing OnClickListener to perform Login action
//        signInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //Getting user details from the edit text
//                String email = emailEditTxt.getText().toString();
//                String password = passwordEditTxt.getText().toString();
//
//                //Checking all the fields are filled or not
//                if (email.isEmpty() || password.isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "Please, Fill Details", Toast.LENGTH_SHORT).show();
//                } else {
//                    //Showing all Gmails
//                    Intent intent = mSignInClient.getSignInIntent();
//                    startActivityForResult(intent, 100);
//                }
//
//            }
//        });
//
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 100) {
//            Task<GoogleSignInAccount> googleSignInAccountTask = GoogleSignIn
//                    .getSignedInAccountFromIntent(data);
//
//            if (googleSignInAccountTask.isSuccessful()) {
//                progressBar.show();
//                try {
//                    GoogleSignInAccount googleSignInAccount = googleSignInAccountTask.getResult(ApiException.class);
//
//                    if (googleSignInAccount != null) {
//                        AuthCredential authCredential = GoogleAuthProvider
//                                .getCredential(googleSignInAccount.getIdToken(), null);
//
//                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
//                                    DatabaseReference myRef = database.getReference().child("users");
//
//                                    //Hashmap to store the userdetails and setting it to fireabse
//                                    HashMap<String, Object> user_details = new HashMap<>();
//
//                                    //Accessing the user details from gmail
//                                    String id = googleSignInAccount.getId().toString();
//                                    String name = googleSignInAccount.getDisplayName().toString();
//                                    String mail = googleSignInAccount.getEmail().toString();
//                                    String pic = googleSignInAccount.getPhotoUrl().toString();
//
//
//                                    String email = emailEditTxt.getText().toString();
//                                    String password = passwordEditTxt.getText().toString();
//
//                                    user_details.put("id", id);
//                                    user_details.put("name", name);
//                                    user_details.put("mail", mail);
//                                    user_details.put("profilepic", pic);
//                                    user_details.put("role", "empty");
//                                    user_details.put("email", email);
//                                    user_details.put("password", password);
//
//                                    //updating the user details in firebase
//                                    myRef.child(id).updateChildren(user_details).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                        @Override
//                                        public void onComplete(@NonNull @NotNull Task<Void> task) {
//                                            if (task.isSuccessful()) {
//                                                progressBar.cancel();
//
//                                                //navigating to the main activity after user successfully registers
//                                                Intent intent = new Intent(getApplicationContext(), UserRoleActivity.class);
//                                                //Clears older activities and tasks
//                                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                                startActivity(intent);
//                                            }
//                                        }
//                                    });
//
//                                }
//                            }
//                        });
//                    }
//
//                } catch (ApiException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//
//

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dataflair.fooddeliveryapp.MainActivity;
import com.dataflair.fooddeliveryapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import coding.insight.cleanuiloginregister.R;


public class LoginActivity extends AppCompatActivity{

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
//


    }

    public void loginClick(View view) {
        switch (view.getId()){
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

        if(rememberMe.isChecked()){

        }


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
