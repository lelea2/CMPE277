package com.example.kdao.assigment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import android.telephony.PhoneNumberFormattingTextWatcher;

public class MainActivity extends AppCompatActivity {

    private EditText url_address;
    private EditText phone_number;
    private String url_string = "";
    private String phone_string = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url_address = (EditText) findViewById(R.id.url_address);
        phone_number = (EditText) findViewById(R.id.phone_text);
        phone_number.addTextChangedListener(new PhoneNumberFormattingTextWatcher()); //mask phone number
    }

    public void launchURL(View v) {
        url_string = url_address.getText().toString();
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(url_string));
        startActivity(browserIntent);
    }

    public void ringPhone(View v) {
        phone_string = phone_number.getText().toString();
        if (phone_string.length() == 0) {
            Toast.makeText(getApplicationContext(),"Please enter valid phone number",Toast.LENGTH_LONG).show();
        }
        String tel = "tel:" + phone_string.replaceAll("[^0-9|\\+]", "");
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse(tel));
        startActivity(phoneIntent);
    }

    public void closeApp(View v) {
        MainActivity.this.finish();
    }
}
