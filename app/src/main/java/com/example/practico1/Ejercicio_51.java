package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.practico1.Ejercicio5.MessageSender;

public class Ejercicio_51 extends AppCompatActivity {

    private LinearLayout messagesContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio51);

        messagesContainer = findViewById(R.id.messagesContainer);

        MessageSender.loadMessages(this, messagesContainer);

        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(view -> {
            sendMessage();
        });

        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(view -> {
            MessageSender.deleteAllMessageViews(this, messagesContainer);
        });

    }

    private void sendMessage() {
        MessageSender.addMessage(this, messagesContainer, "Hola desde ejercicio_51", "Ejercicio_51");
        Intent intent = new Intent(this, Ejercicio_52.class);
        startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        MessageSender.deleteAllMessages(this);
    }

}
