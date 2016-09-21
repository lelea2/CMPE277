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
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(TEMPERATURE, temp);
            intent.setAction("com.example.kdao.farmmanager");
            startService(intent);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Please enter valid value",Toast.LENGTH_LONG).show();
        }
    }

    public void cancelSetting(View v) {
        MainActivity.this.finish();
        System.exit(0);
    }
}
