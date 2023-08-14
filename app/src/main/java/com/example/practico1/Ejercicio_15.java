package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.practico1.Ejercicio15.ProcesadorImagenes;

public class Ejercicio_15 extends AppCompatActivity {
    private ProcesadorImagenes procesadorImagenes;
    LinearLayout linearLayoutImagenes;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio15);

        procesadorImagenes = new ProcesadorImagenes();
        Button botonCargarImagenes = findViewById(R.id.boton_cargar_imagenes);
        linearLayoutImagenes = findViewById(R.id.linearLayout_imagenes); // Inicializa linearLayoutImagenes

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                ImageView imageView = new ImageView(Ejercicio_15.this);
                imageView.setImageBitmap((Bitmap) msg.obj);
                linearLayoutImagenes.addView(imageView);
                return true;
            }
        });

        botonCargarImagenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Carga imágenes de recursos para simplificar el ejemplo
                Bitmap imagen1 = BitmapFactory.decodeResource(getResources(), R.drawable.img);
                Bitmap imagen2 = BitmapFactory.decodeResource(getResources(), R.drawable.img_1);
                Bitmap imagen3 = BitmapFactory.decodeResource(getResources(), R.drawable.img_2);
                Bitmap[] imagenes = {imagen1, imagen2, imagen3};

                for (Bitmap imagen : imagenes) {
                    procesadorImagenes.cargarImagen(imagen);
                    Bitmap imagenProcesada = procesadorImagenes.procesarImagen(imagen);
                    Message message = handler.obtainMessage();
                    message.obj = imagenProcesada;
                    handler.sendMessage(message);
                }
            }
        });
    }
}




