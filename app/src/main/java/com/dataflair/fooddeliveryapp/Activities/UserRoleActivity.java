package com.dataflair.fooddeliveryapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dataflair.fooddeliveryapp.Adapters.AdminOrdersAdapter;
import com.dataflair.fooddeliveryapp.Fragments.AddItemFragment;
import com.dataflair.fooddeliveryapp.MainActivity;
import com.dataflair.fooddeliveryapp.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

public class UserRoleActivity extends AppCompatActivity {

    Button user, adminBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_role);


        //Getting the userid of the user from gMail to store the user details under this id
        FirebaseUser userId = FirebaseAuth.getInstance().getCurrentUser();

        user = (Button) findViewById(R.id.UserBtn);
        adminBtn = (Button) findViewById(R.id.AdminBtn);

        //Implementing on clickListener to save the current users role
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                FirebaseDatabase.getInstance().getReference().child("users")
                        .child(userId)
                        .child("role")
                        .setValue("user").addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
*/
                switch (v.getId()){
                    case R.id.UserBtn:
                        startActivity(new Intent(UserRoleActivity.this, AdminOrdersAdapter.class));
                        break;
                    case R.id.AdminBtn:
                        startActivity(new Intent(UserRoleActivity.this, AddItemFragment.class));
                        break;

                }
            }
        });

        //Implementing on clickListener to save the current admin role
        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase.getInstance().getReference().child("users")
                        .child(String.valueOf(userId))
                        .child("role")
                        .setValue("admin").addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

            }
        });
    }
}