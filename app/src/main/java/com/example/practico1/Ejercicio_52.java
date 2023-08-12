package com.example.practico1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.practico1.Ejercicio5.MessageSender;

public class Ejercicio_52 extends AppCompatActivity {

    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio52);

        messageTextView = findViewById(R.id.messageTextView);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String message = bundle.getString("message");
                if (message != null) {
                    messageTextView.setText(message);

                    // Simulamos el envío de una respuesta asincrónica con coroutine
                    MessageSender.sendMessageAsync("Hola desde ejercicio_52", new MessageSender.MessageCallback() {
                        @Override
                        public void onMessageSent(final String message) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    messageTextView.append("\nRespuesta: " + message);
                                }
                            });
                        }
                    });
                }
            }
        }
    }
}
