package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practico1.Ejercicio11.Descarga;
import com.example.practico1.Ejercicio11.Descargador;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio_11 extends AppCompatActivity {
    private Descargador descargador;
    private List<Descarga> descargas;
    private String rutaDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio11);

        descargador = new Descargador();
        descargas = new ArrayList<>();
        EditText editTextUrl = findViewById(R.id.editTextUrl);
        Button botonDescargar = findViewById(R.id.boton_descargar);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        // Agrega los enlaces de prueba aquí
        String[] urls = {
                "https://concepto.de/wp-content/uploads/2022/05/meme-e1653582504105.jpg",
                "https://media.sproutsocial.com/uploads/meme-example.jpg"
        };

        botonDescargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (String urlArchivo : urls) {
                    rutaDestino = getExternalFilesDir(null) + "/" + urlArchivo.substring(urlArchivo.lastIndexOf('/') + 1);

                    ProgressBar progressBar = new ProgressBar(Ejercicio_11.this, null, android.R.attr.progressBarStyleHorizontal);
                    progressBar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    TextView textView = new TextView(Ejercicio_11.this);
                    textView.setText("0%");

                    linearLayout.addView(progressBar);
                    linearLayout.addView(textView);

                    Descarga descarga = new Descarga(urlArchivo, rutaDestino, progressBar, textView);
                    descargas.add(descarga);

                    descargador.descargarArchivo(urlArchivo, rutaDestino, new Descargador.OnProgressListener() {
                        @Override
                        public void onProgress(int porcentaje) {
                            descarga.progressBar.setProgress(porcentaje);
                            descarga.textView.setText(porcentaje + "%");
                        }

                        @Override
                        public void onComplete() {
                            descarga.textView.setText("Descarga completada");
                            Toast.makeText(Ejercicio_11.this, "Archivo descargado en: " + rutaDestino, Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onError(Exception e) {
                            descarga.textView.setText("Error en la descarga: " + e.getMessage());
                        }
                    });
                }
            }
        });
        Button botonRutaDescarga = findViewById(R.id.boton_ruta_descarga);
        botonRutaDescarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rutaDestino != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(rutaDestino), "resource/folder");
                    startActivity(Intent.createChooser(intent, "Abrir carpeta de descarga"));
                } else {
                    Toast.makeText(Ejercicio_11.this, "No se ha descargado ningún archivo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
