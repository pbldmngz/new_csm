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
                showDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder alert;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alert = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        }
        else {
            alert = new AlertDialog.Builder(this);
        }

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.login_data, null);

        name = view.findViewById(R.id.edUsername);
        password = view.findViewById(R.id.edPassword);

        alert.setView(view);
        alert.setCancelable(false);

        AlertDialog dialog = alert.create();
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();

        btn_login = view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(name.getText().toString(), password.getText().toString());
            }
        });


    }

    private void Validate(String userName, String userPassword) {
        if((userName.equals("admin")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(LoginActivity.this, profileFragment.class);
            startActivity(intent);
        }
        else {
            counter--;

            info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0) {
                show_login.setEnabled(false);
            }
        }
    }
}
