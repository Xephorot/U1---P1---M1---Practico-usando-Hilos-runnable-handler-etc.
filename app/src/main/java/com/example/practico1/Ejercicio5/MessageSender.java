package com.example.practico1.Ejercicio5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MessageSender {

    public static class MessageHandler implements Parcelable {
        private Handler handler;

        public MessageHandler(Handler handler) {
            this.handler = handler;
        }

        protected MessageHandler(Parcel in) {
            handler = (Handler) in.readValue(Handler.class.getClassLoader());
        }

        public Handler getHandler() {
            return handler;
        }

        public static final Creator<MessageHandler> CREATOR = new Creator<MessageHandler>() {
            @Override
            public MessageHandler createFromParcel(Parcel in) {
                return new MessageHandler(in);
            }

            @Override
            public MessageHandler[] newArray(int size) {
                return new MessageHandler[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(handler);
        }
    }
    public static void saveMessage(Context context, String message, String sender) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("messages", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int messageCount = sharedPreferences.getInt("messageCount", 0);
        editor.putString("message_" + messageCount, sender + ": " + message);
        editor.putInt("messageCount", messageCount + 1);
        editor.apply();
    }
    public static void addMessage(Context context, LinearLayout messagesContainer, String message, String sender) {
        saveMessage(context, message, sender);
        TextView textView = new TextView(context);
        textView.setText(sender + ": " + message);
        textView.setTag("message");
        messagesContainer.addView(textView);
    }

    public static void loadMessages(Context context, LinearLayout messagesContainer) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("messages", Context.MODE_PRIVATE);
        int messageCount = sharedPreferences.getInt("messageCount", 0);
        for (int i = 0; i < messageCount; i++) {
            String message = sharedPreferences.getString("message_" + i, null);
            if (message != null) {
                TextView textView = new TextView(context);
                textView.setText(message);
                textView.setTag("message");
                messagesContainer.addView(textView);
            }
        }
    }
    public static void deleteAllMessages(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("messages", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putInt("messageCount", 0);
        editor.apply();
    }

    public static void deleteAllMessageViews(Context context, LinearLayout messagesContainer) {
        for (int i = messagesContainer.getChildCount() - 1; i >= 0; i--) {
            View child = messagesContainer.getChildAt(i);
            if (child instanceof TextView && child.getTag() != null && child.getTag().equals("message")) {
                messagesContainer.removeViewAt(i);
            }
        }
        deleteAllMessages(context);
    }
}
