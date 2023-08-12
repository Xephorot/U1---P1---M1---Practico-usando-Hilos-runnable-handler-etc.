package com.example.practico1.Ejercicio3;

import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageReceiver {
    public static void startServer() {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                while (true) {
                    Socket socket = serverSocket.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String messageText = reader.readLine();
                    reader.close();
                    socket.close();

                    android.os.Message message = android.os.Message.obtain(); // Crear el objeto Message
                    message.obj = messageText; // Asignar el contenido del mensaje

                    // Agregar el mensaje recibido al ChatManager
                    ChatManager.getInstance().receiveMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
