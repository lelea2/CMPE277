package com.example.kdao.iot_farm_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;
import android.os.Handler;

public class FarmMaintenance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_maintenance);
    }

    public static class MyReceiver extends BroadcastReceiver {

        private final Handler handler; // Handler used to execute code on the UI thread

        public MyReceiver(Handler handler) {
            this.handler = handler;
        }

        @Override
        public void onReceive(final Context context, Intent intent) {
            // Post the UI updating code to our Handler
            handler.post(new Runnable() {
                @Override
                    public void run() {
                    Toast.makeText(context, "Toast from broadcast receiver", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}