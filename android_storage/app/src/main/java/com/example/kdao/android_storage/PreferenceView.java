package com.example.kdao.android_storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PreferenceView extends AppCompatActivity {

    private EditText bookName;
    private EditText authorName;
    private EditText desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_view);
        bookName = (EditText) findViewById(R.id.book_name_text);
        authorName = (EditText) findViewById(R.id.book_name_text);
        desc = (EditText) findViewById(R.id.desc_text);
    }

    public void savePreference(View v) {

    }

    public void cancelActivity(View v) {
        Intent intent = new Intent(PreferenceView.this, MainActivity.class);
        startActivity(intent);
    }
}
