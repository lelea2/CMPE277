package com.example.kdao.assignment1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;


public class ActivityA extends AppCompatActivity {

    private TextView threadCount;
    private TextView bundleCount;
    private int thread_numb = 0;
    private int bundle_numb = 0;
    private static final String BUNDLE_COUNT = "bundle_count";
    private boolean shouldPrintThread = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println(">>>>>>>>> on Created <<<<<<<<<<<<<<");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (savedInstanceState != null) {
        }
        setContentView(R.layout.activity_a);
        threadCount = (TextView)findViewById(R.id.threads_count);
        bundleCount = (TextView)findViewById(R.id.bundles_count);
    }

    @Override
    protected void onRestart() {
        System.out.println(">>>>>>>>>>>>> on Restart <<<<<<<<<<<<<");
        shouldPrintThread = true; //re-start activity (navigate back), should print
        super.onRestart();
    }

    @Override
    protected void onResume() {
        System.out.println(">>>>>>>>>> on Resume <<<<<<<<<<<<<<");
        if (shouldPrintThread == true) {
            printThreadCount();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        System.out.println(">>>>>> on Pause <<<<<<<<<");
        shouldPrintThread = false; //dialog open should not enable thread
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println(">>>>>>> on Stop <<<<<<<<<");
        shouldPrintThread = false;
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        shouldPrintThread = false;
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
            bundleCount.setText(String.format("%05d", bundle_numb_count));
            bundle_numb++;
        }
    }

    /**
     * Private function to print threadcount
     */
    private void printThreadCount() {
        thread_numb = thread_numb + 1;
        threadCount.setText(String.format("%05d", thread_numb));
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
