package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.login);
        Button homeBtn = findViewById(R.id.homeBtn);

        EditText nameTxt, emailTxt;
        nameTxt = findViewById(R.id.name);
        emailTxt = findViewById(R.id.email);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameTxt.getText().toString();
                String email = emailTxt.getText().toString();
                String result = name + " logged in with email: " + email;
                if(name.matches("") || email.matches(""))
                {
                    Toast.makeText(LoginActivity.this, "All Fields necessary", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, result, Toast.LENGTH_LONG).show();
                    nameTxt.setText("");
                    emailTxt.setText("");
                }
            }
        });
    }
}