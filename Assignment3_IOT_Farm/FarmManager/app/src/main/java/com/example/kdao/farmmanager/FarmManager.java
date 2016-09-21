package com.example.kdao.farmmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FarmManager extends AppCompatActivity {

    private Button controlFan;
    private Button controlFanAndSprinkle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_manager);
        controlFan = (Button) findViewById(R.id.btn_1);
        controlFanAndSprinkle = (Button) findViewById(R.id.btn_2);
    }

    public void turnFanOn(View v) {

    }

    public void turnFanSprinklerOn(View v) {

    }
}
