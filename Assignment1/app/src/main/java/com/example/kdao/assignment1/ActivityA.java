package com.example.kdao.assignment1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class ActivityA extends AppCompatActivity {

    private TextView threadCount;
    private TextView bundleCount;
    private int thread_numb = 0;
    private int bundle_numb = 0;
    private static final String BUNDLE_COUNT = "bundle_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(savedInstanceState);
        if (savedInstanceState != null) {
        }
        setContentView(R.layout.activity_a);
        threadCount = (TextView)findViewById(R.id.threads_count);
        bundleCount = (TextView)findViewById(R.id.bundles_count);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        System.out.println("on saved instance");
        bundle_numb++;
        savedInstanceState.putInt(BUNDLE_COUNT, bundle_numb);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        System.out.println("on restore instance");
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println(savedInstanceState);
        if (savedInstanceState != null) {
            int bundle_numb_count = savedInstanceState.getInt(BUNDLE_COUNT);
            bundleCount.setText(bundle_numb_count);
            bundle_numb++;
        }
    }


    public void startDialog(View v) {
        Intent intent = new Intent(ActivityA.this, DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }


    public void closeApp(View v) {
        ActivityA.this.finish();
    }
}
