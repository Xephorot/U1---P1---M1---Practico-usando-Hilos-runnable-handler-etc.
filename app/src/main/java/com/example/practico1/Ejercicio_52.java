package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.practico1.Ejercicio5.MessageSender;

public class Ejercicio_52 extends AppCompatActivity {

    private LinearLayout messagesContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio52);

        messagesContainer = findViewById(R.id.messagesContainer2);

        MessageSender.loadMessages(this, messagesContainer);

        Button sendButton52 = findViewById(R.id.sendButton52);
        sendButton52.setOnClickListener(view -> {
            sendMessageFrom52();
        });

        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(view -> {
            MessageSender.deleteAllMessageViews(this, messagesContainer);
        });
    }

    private void sendMessageFrom52() {
        MessageSender.addMessage(this, messagesContainer, "Hola desde ejercicio_52", "Ejercicio_52");
        Intent intent = new Intent(this, Ejercicio_51.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MessageSender.deleteAllMessages(this);
    }

}
