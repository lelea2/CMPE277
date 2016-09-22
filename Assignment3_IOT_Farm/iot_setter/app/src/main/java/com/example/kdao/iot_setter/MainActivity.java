package com.example.kdao.iot_setter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText temperature;
    private EditText humidity;
    private static final String TEMPERATURE = "TEMPERATURE";
    private static final String ACTION_NAME = "com.example.kdao.farmmanager.SET_CONDITION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temperature = (EditText) findViewById(R.id.temperature);
        humidity = (EditText) findViewById(R.id.humidity);
    }

    /**
     * Helper function handle set temperature
     * @param v
     */
    public void setCondition(View v) {
        try {
            int temp = Integer.parseInt(temperature.getText().toString());
            int humidity = Integer.parseInt(temperature.getText().toString());
            Intent broadcastIntent = new Intent(ACTION_NAME);
            broadcastIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            broadcastIntent.putExtra(TEMPERATURE, temp);
            sendBroadcast(broadcastIntent);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Please enter valid value",Toast.LENGTH_LONG).show();
        }
    }

    public void cancelSetting(View v) {
        MainActivity.this.finish();
        System.exit(0);
    }
}
