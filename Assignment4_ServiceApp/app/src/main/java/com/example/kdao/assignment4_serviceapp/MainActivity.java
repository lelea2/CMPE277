package com.example.kdao.assignment4_serviceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.widget.Toast;
import android.content.IntentFilter;

public class MainActivity extends AppCompatActivity {

    private EditText file1;
    private EditText file2;
    private EditText file3;
    private EditText file4;
    private EditText file5;

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String string = bundle.getString(MyService.FILE_PATH);
                int resultCode = bundle.getInt(MyService.RESULT);
                if (resultCode == RESULT_OK) {
                    Toast.makeText(MainActivity.this, "Download file completed, url: " + string, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Download file failed", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

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

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(intentReceiver, new IntentFilter(MyService.NOTIFICATION));
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(intentReceiver);
    }

    /**
     * Function handle download file click
     * @param v
     */
    public void downloadFile(View v) {
        String url1 = file1.getText().toString();
        String url2 = file2.getText().toString();
        String url3 = file3.getText().toString();
        String url4 = file4.getText().toString();
        String url5 = file5.getText().toString();
        handleDownloadIntent(url1, "pdf_1");
        handleDownloadIntent(url2, "pdf_2");
        handleDownloadIntent(url3, "pdf_3");
        handleDownloadIntent(url4, "pdf_4");
        handleDownloadIntent(url5, "pdf_5");
    }

    private void handleDownloadIntent(String urlFile, String filename) {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra(MyService.FILE_NAME, filename);
        intent.putExtra(MyService.URL, urlFile);
        startService(intent);
        Toast.makeText(MainActivity.this, "Download started for " + filename, Toast.LENGTH_SHORT).show();
    }
}
