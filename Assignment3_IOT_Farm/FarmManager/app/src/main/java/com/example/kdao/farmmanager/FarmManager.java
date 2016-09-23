package com.example.kdao.farmmanager;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class FarmManager extends AppCompatActivity {

    private Button controlFan;
    private Button controlFanAndSprinkle;
    private IntentFilter intentFilter;
    private static final String ACTION_RECEIVE = "com.example.kdao.farmmanager.SET_CONDITION";
    private static final String ACTION_BROADCAST = "com.example.kdao.farmmaintenance.TYPE_ON";
    private static final String TYPE_ON = "TYPE_ON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_manager);
        controlFan = (Button) findViewById(R.id.btn_1);
        controlFanAndSprinkle = (Button) findViewById(R.id.btn_2);
        controlFan.setEnabled(false);
        controlFanAndSprinkle.setEnabled(false);
        intentFilter = new IntentFilter(ACTION_RECEIVE);
    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            FarmManager.this.receivedBroadcast(context, intent);
        }
    };


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(this.mBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mBroadcastReceiver);
    }

    //Handle receive broadcast event
    private void receivedBroadcast(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_RECEIVE)) {
            Toast.makeText(context, "Receive new Temperature and Humidity Setting.", Toast.LENGTH_LONG).show();
            int temp = intent.getIntExtra("TEMPERATURE", 0);
            controlFan.setEnabled(false);
            controlFanAndSprinkle.setEnabled(false);
            if (temp >= 70 && temp <= 90) {
                Toast.makeText(context, "Enable TURN FAN ON button.", Toast.LENGTH_LONG).show();
                controlFan.setEnabled(true);
            } else if (temp > 90 && temp <= 125) {
                Toast.makeText(context, "Enable TURN FAN&SPRINKLER ON button.", Toast.LENGTH_LONG).show();
                controlFanAndSprinkle.setEnabled(true);
            } else {
                Toast.makeText(context, "Temperature do not fall in the range. Not enable button.", Toast.LENGTH_LONG).show();
            }
        } else {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = (activeNetwork != null && activeNetwork.isConnectedOrConnecting());
            if (isConnected) {
                try {
                    Toast.makeText(context, "Network is connected", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(context, "Network is changed or reconnected", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * Helper function to turn on fan and sprinkler
     * @param v
     */
    public void turnFanSprinklerOn(View v) {
        broadcastAction(2);
    }

    /**
     * Helper function to turn fan on
     * @param v
     */
    public void turnFanOn(View v) {
        broadcastAction(1);
    }

    private void broadcastAction(int type) {
        Intent broadcastIntent = new Intent(ACTION_BROADCAST);
        broadcastIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        broadcastIntent.putExtra(TYPE_ON, type);
        sendBroadcast(broadcastIntent);
    }
}
