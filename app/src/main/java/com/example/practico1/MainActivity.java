package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button Ejercicio_1;
    private Button Ejercicio_3;
    private Button Ejercicio_5;
    private Button Ejercicio_7;
    private Button Ejercicio_9;
    private Button Ejercicio_11;
    private Button Ejercicio_13;
    private Button Ejercicio_15;
    private Button EjerciciosRecursividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EjerciciosRecursividad = findViewById(R.id.btn_ejercicioRecursividad);
        Ejercicio_1 = findViewById(R.id.btn_ejercicio1);
        Ejercicio_3 = findViewById(R.id.btn_ejercicio3);
        Ejercicio_5 = findViewById(R.id.btn_ejercicio5);
        Ejercicio_7 = findViewById(R.id.btn_ejercicio7);
        Ejercicio_9 = findViewById(R.id.btn_ejercicio9);
        Ejercicio_11 = findViewById(R.id.btn_ejercicio11);
        Ejercicio_13 = findViewById(R.id.btn_ejercicio13);
        Ejercicio_15 = findViewById(R.id.btn_ejercicio15);

        Ejercicio_1.setOnClickListener(view-> {
            Intent intent = new Intent (MainActivity.this, ImageListActivity.class);
            startActivity(intent);
        });

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
        Ejercicio_9.setOnClickListener(view->{
            Intent intent = new Intent(MainActivity.this, ChronometerActivity.class);
            startActivity(intent);
        });
        Ejercicio_11.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio_11.class);
            startActivity(intent);
        });
        Ejercicio_13.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio_13.class);
            startActivity(intent);
        });
        Ejercicio_15.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio_15.class);
            startActivity(intent);
        });
        EjerciciosRecursividad.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainRecursividadActivity.class);
            startActivity(intent);
        });
    }
}