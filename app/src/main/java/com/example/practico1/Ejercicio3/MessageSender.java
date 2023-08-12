package com.example.practico1.Ejercicio3;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class MessageSender {
    public static void sendMessage(final String messageText, final String ipAddress, final int port) {
        new Thread(() -> {
            try {
                Socket socket = new Socket(ipAddress, port);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(messageText.getBytes());
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
