package com.example.kdao.assignment4_serviceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import java.net.URL;
import java.net.MalformedURLException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText file1;
    private EditText file2;
    private EditText file3;
    private EditText file4;
    private EditText file5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        file1 = (EditText) findViewById(R.id.file_1);
        file2 = (EditText) findViewById(R.id.file_2);
        file3 = (EditText) findViewById(R.id.file_3);
        file4 = (EditText) findViewById(R.id.file_4);
        file5 = (EditText) findViewById(R.id.file_5);
    }

    public void downloadFile(View v) {
        Intent intent = new Intent(getBaseContext(), MyService.class);
        String url1 = file1.getText().toString();
        String url2 = file2.getText().toString();
        String url3 = file3.getText().toString();
        String url4 = file4.getText().toString();
        String url5 = file5.getText().toString();
        try {
            URL[] urls = new URL[]{
                    new URL(url1),
                    new URL(url2),
                    new URL(url3),
                    new URL(url4),
                    new URL(url5)
                };
            intent.putExtra("URLs", urls);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        startService(intent);
    }

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getBaseContext(), "File downloaded!", Toast.LENGTH_LONG).show();
        }
    };

}
