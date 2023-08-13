package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practico1.Ejercicio9.Chronometer;

public class ChronometerActivity extends AppCompatActivity {
    private TextView timerTextView;
    private Button startButton, pauseButton, resetButton;
    private Handler handler = new Handler();
    private Chronometer chronometer = new Chronometer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);

        timerTextView = findViewById(R.id.timerTextView);
        startButton = findViewById(R.id.startButton);
        pauseButton = findViewById(R.id.pauseButton);
        resetButton = findViewById(R.id.resetButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.start();
                handler.postDelayed(updateTimerRunnable, 0);
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.pause();
                handler.removeCallbacks(updateTimerRunnable);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.reset();
                timerTextView.setText("00:00:000");
            }
        });
    }

    private Runnable updateTimerRunnable = new Runnable() {
        @Override
        public void run() {
            long elapsedTime = chronometer.getElapsedTime();
            int millis = (int) (elapsedTime % 1000);
            int seconds = (int) (elapsedTime / 1000) % 60;
            int minutes = (int) (elapsedTime / (1000 * 60)) % 60;
            timerTextView.setText(String.format("%02d:%02d:%03d", minutes, seconds, millis));
            handler.postDelayed(this, 10);
        }
    };
}
