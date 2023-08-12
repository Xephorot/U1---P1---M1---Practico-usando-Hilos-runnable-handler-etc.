package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button Ejercicio_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ejercicio_3 = findViewById(R.id.btn_ejercicio3);

        Ejercicio_3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio_3.class);
            startActivity(intent);
        });
    }
}