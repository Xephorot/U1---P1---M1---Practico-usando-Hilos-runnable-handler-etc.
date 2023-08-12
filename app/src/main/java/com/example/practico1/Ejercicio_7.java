package com.example.practico1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practico1.Ejercicio7.Temporizador;

public class Ejercicio_7 extends AppCompatActivity {
    private Temporizador temporizador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio7);

        long intervalo = 5000; // Intervalo en milisegundos, por ejemplo, 5000 ms (5 segundos)
        temporizador = new Temporizador(intervalo);
        temporizador.iniciar(() -> {
            temporizador.mostrarToastConSonido(getApplicationContext(), "Notificación periódica");
        });

        Button botonForzarNotificacion = findViewById(R.id.boton_forzar_notificacion);
        botonForzarNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporizador.mostrarToastConSonido(getApplicationContext(), "Notificación forzada");
            }
        });
        Button botonDetenerNotififaciones = findViewById(R.id.boton_dentener_notificaciones);
        botonDetenerNotififaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temporizador.detener();
            }
        });
    }
}


