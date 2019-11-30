package com.example.menutest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private TextView info;
    private Button show_login, btn_login, btn_close;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        show_login = (Button) findViewById(R.id.show_login);

        show_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogin();
            }
        });
    }

    private void showLogin() {

        setContentView(R.layout.login_data);

        name = findViewById(R.id.edUsername);
        password = findViewById(R.id.edPassword);
        info = findViewById(R.id.info);

        info.setText("Number of attempts remaining: 5");

        btn_login = findViewById(R.id.btn_login);
        btn_close = findViewById(R.id.btn_close);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(name.getText().toString(), password.getText().toString());
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });
    }

    private void Validate(String userName, String userPassword) {
        if(dataController.validLogin(userName, userPassword) == true) {
            //dataController.setUser(dataController.getId(userName));
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        else {
            counter --;
            info.setText("Number of attempts remaining: " + String.valueOf(counter));

            if (counter == 0) {
                btn_login.setEnabled(false);
            }
        }

    }
}
