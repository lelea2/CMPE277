package com.example.kdao.iot_farm_broadcastreceiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText temperature;
    private EditText humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temperature = (EditText) findViewById(R.id.temperature);
        humidity = (EditText) findViewById(R.id.humidity);
    }

    public void setCondition(View v) {

    }

    public void cancelSetting(View v) {

    }
}
