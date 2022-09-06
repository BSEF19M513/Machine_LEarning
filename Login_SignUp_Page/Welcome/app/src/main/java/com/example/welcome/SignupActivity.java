package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        DBHelper helper = new DBHelper(this);
        Button homeBtn = findViewById(R.id.homeBtn);
        Button login = findViewById(R.id.login);
        EditText nameTxt, emailTxt, passwordTxt, cpasswordTxt;
        nameTxt = findViewById(R.id.name);
        emailTxt = findViewById(R.id.email);
        passwordTxt = findViewById(R.id.password);
        cpasswordTxt = findViewById(R.id.cpassword);

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
                String password = passwordTxt.getText().toString();
                String cpassword = cpasswordTxt.getText().toString();
                Boolean isInserted = helper.addRecord(name, email, password);
                if(isInserted)
                {
                    Toast.makeText(SignupActivity.this, "Record inserted Successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                if(name.matches("") || email.matches("") || password.matches("") || cpassword.matches(""))
                {
                    Toast.makeText(SignupActivity.this, "All fields are required", Toast.LENGTH_LONG).show();
                    return;
                }

                else
                {
                    Toast.makeText(SignupActivity.this, "Record not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}