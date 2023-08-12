package com.example.practico1.Ejercicio3;

import android.os.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private static ChatManager instance;
    private List<Message> messages;
    private OnMessageUpdateListener messageUpdateListener;

    private ChatManager() {
        messages = new ArrayList<>();
    }

    public static synchronized ChatManager getInstance() {
        if (instance == null) {
            instance = new ChatManager();
        }
        return instance;
    }

    public void sendMessage(final Message message) {
        messages.add(message);
        notifyUIUpdate();
    }

    public void receiveMessage(Message message) {
        messages.add(message);
        notifyUIUpdate();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public interface OnMessageUpdateListener {
        void onMessageUpdate(List<Message> messages);
    }

    public void setMessageUpdateListener(OnMessageUpdateListener listener) {
        messageUpdateListener = listener;
    }

    private void notifyUIUpdate() {
        if (messageUpdateListener != null) {
            messageUpdateListener.onMessageUpdate(messages);
        }
    }
}
