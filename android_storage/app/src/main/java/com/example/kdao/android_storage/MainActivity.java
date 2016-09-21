package com.example.kdao.android_storage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoPreference(View v) {
        Intent intent = new Intent(MainActivity.this, PreferenceView.class);
        startActivity(intent);
    }

    public void gotoSQLite(View v) {
        Intent intent = new Intent(MainActivity.this, SQLiteView.class);
        startActivity(intent);
    }

    public void closeApp(View v) {
        MainActivity.this.finish();
    }
}
