package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ejercicio_51 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio51);

        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(view -> {
            sendMessage();
        });
    }

    private void sendMessage() {
        Intent intent = new Intent(this, Ejercicio_52.class);
        Bundle bundle = new Bundle();
        bundle.putString("message", "Hola desde ejercicio_51");
        intent.putExtras(bundle);
        startActivity(intent);
    }
}