package com.example.practico1.Ejercicio7;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.practico1.R;

public class Temporizador {
    private Handler handler;
    private Runnable runnable;
    private long intervalo;

    public Temporizador(long intervalo) {
        this.intervalo = intervalo;
        handler = new Handler(Looper.getMainLooper());
    }

    public void iniciar(Runnable tarea) {
        runnable = new Runnable() {
            @Override
            public void run() {
                tarea.run();
                handler.postDelayed(this, intervalo);
            }
        };
        handler.postDelayed(runnable, intervalo);
    }

    public void detener() {
        handler.removeCallbacks(runnable);
    }

    public void enviarNotificacionConSonido(Context context) {
        String channelId = "notificaciones_periodicas";
        String channelName = "Notificaciones periódicas";
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
            Uri sonido = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.sound);
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            channel.setSound(sonido, audioAttributes);
            notificationManager.createNotificationChannel(channel);
        }

        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new Notification.Builder(context, channelId);
        } else {
            builder = new Notification.Builder(context);
        }

        builder.setSmallIcon(R.drawable.img)
                .setContentTitle("Notificación periódica")
                .setContentText("Esta es una notificación periódica.")
                .setAutoCancel(true)
                .setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.sound));

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            builder.setPriority(Notification.PRIORITY_HIGH);
        }

        notificationManager.notify(1, builder.build());
        Log.d("Temporizador", "Notificación enviada");
    }
    public void mostrarToastConSonido(Context context, String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();

        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.sound);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        mediaPlayer.start();
    }
}
