package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button Ejercicio_3;
    private Button Ejercicio_5;
    private Button Ejercicio_7;
    private Button Ejercicio_11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ejercicio_3 = findViewById(R.id.btn_ejercicio3);
        Ejercicio_5 = findViewById(R.id.btn_ejercicio5);
        Ejercicio_7 = findViewById(R.id.btn_ejercicio7);
        Ejercicio_11 = findViewById(R.id.btn_ejercicio11);

        Ejercicio_3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio_3.class);
            startActivity(intent);
        });

        Ejercicio_5.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio_51.class);
            startActivity(intent);
        });
        Ejercicio_7.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio_7.class);
            startActivity(intent);
        });
        Ejercicio_11.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio_11.class);
            startActivity(intent);
        });
    }
}