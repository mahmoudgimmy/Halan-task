package com.example.halanchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText userNameEt, passwordEt;
    Button loginBtn;
    Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEt = findViewById(R.id.et_username);
        passwordEt = findViewById(R.id.et_password);
        loginBtn = findViewById(R.id.btn_login);

        login = new Login();


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.login(userNameEt.getText().toString(), passwordEt.getText().toString(),getApplicationContext());
            }
        });

    }
}

