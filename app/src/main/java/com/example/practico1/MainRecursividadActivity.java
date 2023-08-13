package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.practico1.R;

public class MainRecursividadActivity extends AppCompatActivity {
    private Button Ejercicio_17;
    private Button Ejercicio_19;
    private Button Ejercicio_21;
    private Button Ejercicio_23;
    private Button Ejercicio_25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recursividad);

        Ejercicio_17 = findViewById(R.id.btn_ejercicio17);
        Ejercicio_19 = findViewById(R.id.btn_ejercicio19);
        Ejercicio_21 = findViewById(R.id.btn_ejercicio21);
        Ejercicio_23 = findViewById(R.id.btn_ejercicio23);
        Ejercicio_25 = findViewById(R.id.btn_ejercicio25);

        Ejercicio_17.setOnClickListener(view -> {
            Intent intent = new Intent(MainRecursividadActivity.this, MaxNumberActivity.class);
            startActivity(intent);
        });
        Ejercicio_19.setOnClickListener(view->{
            Intent intent = new Intent( MainRecursividadActivity.this,NaturalNumbersSumActivity.class);
            startActivity(intent);
        });
        Ejercicio_21.setOnClickListener(view -> {
            Intent intent = new Intent(MainRecursividadActivity.this, GCDActivity.class);
            startActivity(intent);
        });
        Ejercicio_23.setOnClickListener(view -> {
            Intent intent = new Intent(MainRecursividadActivity.this, EjerciciosRecursividad.class);
            startActivity(intent);
        });
        Ejercicio_25.setOnClickListener(view -> {
            Intent intent = new Intent(MainRecursividadActivity.this, DigitsSumActivity.class);
            startActivity(intent);
        });
    }
}