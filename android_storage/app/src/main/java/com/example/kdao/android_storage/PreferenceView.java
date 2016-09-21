package com.example.kdao.android_storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PreferenceView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_view);
    }

    public void savePreference(View v) {

    }

    public void cancelActivity(View v) {
        Intent intent = new Intent(PreferenceView.this, MainActivity.class);
        startActivity(intent);
    }
}
