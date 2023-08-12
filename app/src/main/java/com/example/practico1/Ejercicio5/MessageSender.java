package com.example.practico1.Ejercicio5;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class MessageSender {

    public interface MessageCallback {
        void onMessageSent(String message);
    }

    public static void sendMessageAsync(final String message, final MessageCallback callback) {
        // Simulamos una tarea asincrónica usando una coroutine
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Simulamos un retraso en el envío del mensaje
                try {
                    Thread.sleep(2000); // 2 segundos de retraso
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Usamos un Handler para volver al hilo principal
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onMessageSent(message);
                    }
                });
            }
        }).start();
    }
}
