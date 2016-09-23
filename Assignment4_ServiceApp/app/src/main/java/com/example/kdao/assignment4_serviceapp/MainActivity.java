package com.example.kdao.assignment4_serviceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    }
}
