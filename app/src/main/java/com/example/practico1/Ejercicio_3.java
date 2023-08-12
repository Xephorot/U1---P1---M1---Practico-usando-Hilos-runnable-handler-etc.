package com.example.practico1;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practico1.Ejercicio3.ChatManager;
import com.example.practico1.Ejercicio3.MessageReceiver;
import com.example.practico1.Ejercicio3.MessageSender;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class Ejercicio_3 extends AppCompatActivity {

    private EditText editTextIP;
    private EditText editTextPort;
    private ListView listViewMessages;
    private EditText editTextMessage;
    private Button btnConnect;
    private Button btnSend;

    private ChatManager chatManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        editTextIP = findViewById(R.id.editTextIP);
        editTextPort = findViewById(R.id.editTextPort);
        listViewMessages = findViewById(R.id.listViewMessages);
        editTextMessage = findViewById(R.id.editTextMessage);
        btnConnect = findViewById(R.id.btnConnect);
        btnSend = findViewById(R.id.btnSend);

        chatManager = ChatManager.getInstance();

        // Set default IP and port
        editTextIP.setText(getIpAddress()); // Obtener la dirección IP local
        editTextPort.setText("8080");       // Puerto local por defecto

        // Configure button listeners
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Connect logic
                String ip = editTextIP.getText().toString();
                String port = editTextPort.getText().toString();

                // You can use 'ip' and 'port' for connection logic

                // Start the server to receive messages
                MessageReceiver.startServer();
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = editTextMessage.getText().toString();
                if (!messageText.isEmpty()) {
                    String ipAddress = editTextIP.getText().toString();
                    int port = Integer.parseInt(editTextPort.getText().toString());

                    MessageSender.sendMessage(messageText, ipAddress, port); // Envía el mensaje al servidor
                    editTextMessage.getText().clear();
                }
            }
        });


        ArrayAdapter<android.os.Message> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chatManager.getMessages());
        listViewMessages.setAdapter(adapter);

        // Set message update listener
        chatManager.setMessageUpdateListener(new ChatManager.OnMessageUpdateListener() {
            @Override
            public void onMessageUpdate(final List<android.os.Message> messages) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    // Esta función obtiene la dirección IP local de tu dispositivo
    public String getIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                for (Enumeration<NetworkInterface> en = networkInterfaces; en.hasMoreElements();) {
                    NetworkInterface intf = en.nextElement();
                    Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();
                    while (enumIpAddr.hasMoreElements()) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                            return inetAddress.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
