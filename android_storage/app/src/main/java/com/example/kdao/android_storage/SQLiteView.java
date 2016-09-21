package com.example.kdao.android_storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SQLiteView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_view);
    }

    public void saveSQLite(View v) {

    }
    
    public void cancelActivity(View v) {
        Intent intent = new Intent(SQLiteView.this, MainActivity.class);
        startActivity(intent);
    }
}
