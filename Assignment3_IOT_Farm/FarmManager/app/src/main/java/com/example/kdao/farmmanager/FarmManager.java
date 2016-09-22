package com.example.kdao.farmmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.IntentFilter;

public class FarmManager extends AppCompatActivity {

    private Button controlFan;
    private Button controlFanAndSprinkle;
    private ConnectReceiver receiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_manager);
        controlFan = (Button) findViewById(R.id.btn_1);
        controlFanAndSprinkle = (Button) findViewById(R.id.btn_2);
        receiver = new ConnectReceiver();
        intentFilter = new IntentFilter("com.example.kdao.farmmanager.SET_CONDITION");
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }


    public void turnFanOn(View v) {

    }

    public void turnFanSprinklerOn(View v) {

    }
}
