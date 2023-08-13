package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practico1.Recursividad.Ejercicio19.NaturalNumbersSumCalculator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NaturalNumbersSumActivity extends AppCompatActivity {

    private EditText numberEditText;
    private Button calculateSumButton;
    private TextView resultTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natural_numbers_sum);

        numberEditText = findViewById(R.id.numberEditText);
        calculateSumButton=findViewById(R.id.calculateSumButton);
        resultTextView=findViewById(R.id.resultTextView);

        handler = new Handler(Looper.getMainLooper());

        calculateSumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n =Integer.parseInt(numberEditText.getText().toString());
                NaturalNumbersSumCalculator sumCalculator = new NaturalNumbersSumCalculator(n);
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                Future<Integer> futureResult = executorService.submit (sumCalculator);
                executorService.shutdown();
                handlerResult(futureResult);

            }
        });
    }

    private void handlerResult(Future<Integer> futureResult) {
        int n = Integer.parseInt(numberEditText.getText().toString());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    int sum = futureResult.get();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            resultTextView.setText("La suma de los primeros " + n + " números naturales es: " + sum);
                        }
                    });
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}