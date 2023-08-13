package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practico1.Recursividad.Ejercicio21.GCDCalculator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GCDActivity extends AppCompatActivity {

    private EditText number1EditText, number2EditText;
    private Button calculateGCDButton;
    private TextView resultTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcdactivity);

        number1EditText= findViewById(R.id.number1EditText);
        number2EditText=findViewById(R.id.number2EditText);
        calculateGCDButton=findViewById(R.id.calculateGCDButton);
        resultTextView=findViewById(R.id.resultTextView);

        handler = new Handler(Looper.getMainLooper());
        calculateGCDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(number1EditText.getText().toString());
                int b = Integer.parseInt(number2EditText.getText().toString());
                GCDCalculator gcdCalculator = new GCDCalculator(a,b);
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                Future<Integer> futureResult = executorService.submit(gcdCalculator);
                executorService.shutdown();
                handleResult(futureResult);
            }
        });

    }

    private void handleResult(Future<Integer> futureResult) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    int gcd=futureResult.get();
                    handler.post(new Runnable(){

                        @Override
                        public void run() {
                            resultTextView.setText("El MCD es: " + gcd);
                        }
                    });
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}