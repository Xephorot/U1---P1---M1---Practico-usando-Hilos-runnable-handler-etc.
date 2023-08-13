package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practico1.Recursividad.Ejercicio25.DigitsSumCalculator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DigitsSumActivity extends AppCompatActivity {

    private EditText numberEditText;
    private Button calculateSumButton;
    private TextView resultTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits_sum);

        numberEditText = findViewById(R.id.numberEditText);
        calculateSumButton = findViewById(R.id.calculateSumButton);
        resultTextView = findViewById(R.id.resultTextView);

        handler = new Handler(Looper.getMainLooper());

        calculateSumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(numberEditText.getText().toString());
                DigitsSumCalculator sumCalculator = new DigitsSumCalculator(number);
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                Future<Integer> futureResult = executorService.submit(sumCalculator);
                executorService.shutdown();
                handleResult(futureResult);
            }
        });
    }
    private void handleResult(Future<Integer> futureResult) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int sum = futureResult.get();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            resultTextView.setText("La suma de los dígitos es: " + sum);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}