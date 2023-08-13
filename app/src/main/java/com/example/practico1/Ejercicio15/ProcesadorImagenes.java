package com.example.practico1.Ejercicio15;
import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcesadorImagenes {
    private List<Bitmap> imagenes;
    private ExecutorService executor;

    public ProcesadorImagenes() {
        imagenes = new ArrayList<>();
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void cargarImagen(Bitmap imagen) {
        imagenes.add(imagen);
    }

    public Bitmap procesarImagen(Bitmap imagen) {
        Bitmap imagenGrises = Bitmap.createBitmap(imagen.getWidth(), imagen.getHeight(), Bitmap.Config.ARGB_8888);
        for (int x = 0; x < imagen.getWidth(); x++) {
            for (int y = 0; y < imagen.getHeight(); y++) {
                int pixel = imagen.getPixel(x, y);
                int gray = (Color.red(pixel) + Color.green(pixel) + Color.blue(pixel)) / 3;
                imagenGrises.setPixel(x, y, Color.rgb(gray, gray, gray));
            }
        }
        return imagenGrises;
    }

}

