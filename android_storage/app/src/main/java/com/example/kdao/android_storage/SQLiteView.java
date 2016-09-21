package com.example.kdao.android_storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SQLiteView extends AppCompatActivity {

    private EditText desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_view);
        desc = (EditText) findViewById(R.id.desc_text);
    }

    public void saveSQLite(View v) {

    }

    public void cancelActivity(View v) {
        Intent intent = new Intent(SQLiteView.this, MainActivity.class);
        startActivity(intent);
    }
}
