package com.example.menutest;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class sendMessageClass extends AppCompatActivity {

    EditText id_emisor, id_receptor, message;
    Button messageSend, btnReturn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message_layout);

        id_emisor = (EditText) findViewById(R.id.id_emisor);
        id_receptor = (EditText) findViewById(R.id.id_receptor);
        message = (EditText) findViewById(R.id.messageNotifications);
        btnReturn = (Button) findViewById(R.id.btnReturn);

        final String emisorvalue = id_emisor.getText().toString();
        final int finalValue = Integer.parseInt(emisorvalue);

        final String receptorvalue = id_receptor.getText().toString();
        final int finalValue2 = Integer.parseInt(receptorvalue);

        final String mensaje = message.getText().toString();

        messageSend = (Button) findViewById(R.id.btn_sendMessage);

        messageSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataController.enviar(finalValue, finalValue2, mensaje);

                Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_SHORT).show();
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
