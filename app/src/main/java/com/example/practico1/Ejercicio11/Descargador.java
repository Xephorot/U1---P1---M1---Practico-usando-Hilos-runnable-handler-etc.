package com.example.practico1.Ejercicio11;

import android.os.Handler;
import android.os.Looper;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Descargador {
    private Handler handler;

    public Descargador() {
        handler = new Handler(Looper.getMainLooper());
    }

    public void descargarArchivo(String urlArchivo, String rutaDestino, OnProgressListener listener) {
        new Thread(() -> {
            try {
                URL url = new URL(urlArchivo);
                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                int tamanoArchivo = conexion.getContentLength();

                InputStream inputStream = new BufferedInputStream(url.openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(rutaDestino);
                byte[] buffer = new byte[1024];
                int bytesRead;
                int totalBytesRead = 0;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                    totalBytesRead += bytesRead;
                    int porcentaje = (int) (((double) totalBytesRead / tamanoArchivo) * 100);
                    handler.post(() -> listener.onProgress(porcentaje));
                }

                fileOutputStream.close();
                inputStream.close();
                conexion.disconnect();
                handler.post(listener::onComplete);
            } catch (Exception e) {
                handler.post(() -> listener.onError(e));
            }
        }).start();
    }

    public interface OnProgressListener {
        void onProgress(int porcentaje);
        void onComplete();
        void onError(Exception e);
    }
}
