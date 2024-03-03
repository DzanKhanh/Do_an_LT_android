package com.example.profile2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile_activity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    Button btnSignOut;
   //them textview de xem thong tin user (se them sau)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        btnSignOut = findViewById(R.id.btnSignOut);
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login_activity.class);
            startActivity(intent);
            finish();
        }
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login_activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}