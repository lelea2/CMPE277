package com.example.kdao.android_storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.SharedPreferences.Editor;

public class PreferenceView extends AppCompatActivity {

    private EditText bookName;
    private EditText authorName;
    private EditText desc;
    private int counter = 0;
    private SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy-hh:mm a");
    public final static String STORE_PREFERENCES= "assignment4_pref.txt";
    private final static String COUNTER = "COUNTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_view);
        bookName = (EditText) findViewById(R.id.book_name_text);
        authorName = (EditText) findViewById(R.id.book_name_text);
        desc = (EditText) findViewById(R.id.desc_text);

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        counter = sharedPrefs.getInt(COUNTER, 0);
    }

    /**
     * Helper function to save preference
     * @param v
     */
    public void savePreference(View v) {
        String name = bookName.getText().toString();
        String author = authorName.getText().toString();
        String description = desc.getText().toString();
        if ((name != null) && (author != null) && (description != null)) {
            try {
                counter += 1;
                SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
                Editor editor = sharedPreferences.edit();
                editor.putInt(COUNTER, counter);
                editor.commit();
                OutputStreamWriter out=new OutputStreamWriter(openFileOutput(STORE_PREFERENCES, MODE_APPEND));
                String message="\nSaved Preference " + counter + ", " + s.format(new Date());
                out.write(message);
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else{
            Toast.makeText(getApplicationContext(), "Please enter valid info.",Toast.LENGTH_LONG).show();
            return;
        }

    }

    /**
     * Function to cancel activity
     * @param v
     */
    public void cancelActivity(View v) {
        Intent intent = new Intent(PreferenceView.this, MainActivity.class);
        startActivity(intent);
    }
}