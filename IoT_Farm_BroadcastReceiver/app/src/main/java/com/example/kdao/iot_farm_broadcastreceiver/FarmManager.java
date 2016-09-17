package com.example.kdao.iot_farm_broadcastreceiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class FarmManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_manager);
    }

    public void turnFanOn(View v) {

    }

    public void turnFanSprinklerOn(View v) {

    }

    public void backToSettings(View v) {
        Intent intent = new Intent(FarmManager.this, MainActivity.class);
        startActivity(intent);
    }
}
