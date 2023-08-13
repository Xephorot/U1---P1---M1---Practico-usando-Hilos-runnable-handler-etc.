package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practico1.Recursividad.Ejercicio17.MaxNumberFinder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxNumberActivity extends AppCompatActivity {

    private EditText numbersEditText;
    private Button findMaxButton;
    private TextView resulTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_number);

        numbersEditText=findViewById((R.id.numbersEditText));
        findMaxButton = findViewById(R.id.findMaxButton);
        resulTextView = findViewById(R.id.resultTextView);

        handler = new Handler(Looper.getMainLooper());

        findMaxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] numberStrArray = numbersEditText.getText().toString().split(",");
                int[]numbers = new int[numberStrArray.length];
                for(int i=0; i<numberStrArray.length;i++){
                    numbers[i]=Integer.parseInt(numberStrArray[i]);
                }
                MaxNumberFinder maxNumberFinder = new MaxNumberFinder(numbers);
                ExecutorService executorService= Executors.newSingleThreadExecutor();
                Future<Integer> futureResult = executorService.submit(maxNumberFinder);
                executorService.shutdown();
                handlerResult(futureResult);
            }


        });
    }

    private void handlerResult(Future<Integer> futureResult) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    int maxNumber = futureResult.get();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            resulTextView.setText("El número mayor es: " + maxNumber);
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
