package com.example.kdao.farmmaintenance;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class FarmMaintenance extends AppCompatActivity {

    private Button fanOn;
    private Button sprinklerOn;
    private IntentFilter intentFilter;
    private static final String ACTION_RECEIVE = "com.example.kdao.farmmaintenance.TYPE_ON";
    private static final String TYPE_ON = "TYPE_ON";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_maintenance);
        fanOn = (Button) findViewById(R.id.fan_on);
        sprinklerOn = (Button) findViewById(R.id.spinkler_on);
        fanOn.setEnabled(false);
        sprinklerOn.setEnabled(false);
        intentFilter = new IntentFilter(ACTION_RECEIVE);
    }


    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            FarmMaintenance.this.receivedBroadcast(context, intent);
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

    private void receivedBroadcast(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_RECEIVE)) {
            Toast.makeText(context, "Receive signal to turn fan and sprinkler on.", Toast.LENGTH_LONG).show();
            int type = intent.getIntExtra(TYPE_ON, 0);
            fanOn.setEnabled(false);
            sprinklerOn.setEnabled(false);
            if (type == 1) {
                Toast.makeText(context, "Fan ON.", Toast.LENGTH_LONG).show();
                fanOn.setEnabled(true);
            } else if (type == 2) {
                Toast.makeText(context, "Fan & Sprinkler ON.", Toast.LENGTH_LONG).show();
                fanOn.setEnabled(true);
                sprinklerOn.setEnabled(true);
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
}
