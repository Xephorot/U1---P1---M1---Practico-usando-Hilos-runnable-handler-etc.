package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practico1.Recursividad.Ejercicio23.InversorCadena;

public class EjerciciosRecursividad extends AppCompatActivity {
    private EditText editTextCadena;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_recursividad);

        editTextCadena = findViewById(R.id.editTextCadena);
        textViewResultado = findViewById(R.id.textViewResultado);
        Button botonInvertirCadena = findViewById(R.id.botonInvertirCadena);

        //Ejercicio 23
        botonInvertirCadena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cadena = editTextCadena.getText().toString();
                String cadenaInvertida = InversorCadena.invertirCadena(cadena);
                textViewResultado.setText(cadenaInvertida);
            }
        });
    }
}
