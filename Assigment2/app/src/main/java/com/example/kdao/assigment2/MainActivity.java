package com.example.kdao.assigment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
//import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.TextWatcher;
import java.util.regex.*;
import android.util.Patterns;

public class MainActivity extends AppCompatActivity {

    private EditText url_address;
    private EditText phone_number;
    private String url_string = "";
    private String phone_string = "";
    private String lastChar = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url_address = (EditText) findViewById(R.id.url_address);
        phone_number = (EditText) findViewById(R.id.phone_text);
        //phone_number.addTextChangedListener(new PhoneNumberFormattingTextWatcher()); //mask phone number
        phone_number.addTextChangedListener(new TextWatcher() {
            int length_before = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                length_before = s.length();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (length_before < s.length()) {
                    if (s.length() == 3 || s.length() == 7) {
                        s.append("-");
                    }
                    if (s.length() > 3) {
                        if (Character.isDigit(s.charAt(3))) {
                            s.insert(3, "-");
                        }
                    }
                    if (s.length() > 7) {
                        if (Character.isDigit(s.charAt(7))) {
                            s.insert(7, "-");
                        }
                    }
                }
            }
        });
    }

    public void launchURL(View v) {
        url_string = url_address.getText().toString();
        if (url_string.length() == 0 || isValidUrl(url_string) == false) {
            Toast.makeText(getApplicationContext(),"Please enter valid url",Toast.LENGTH_LONG).show();
            return;
        }
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(url_string));
        startActivity(browserIntent);
    }

    /**
     * Validdate url
     * @param url
     * @return
     */
    private boolean isValidUrl(String url) {
        Pattern p = Patterns.WEB_URL;
        Matcher m = p.matcher(url);
        if(m.matches())
            return true;
        else
            return false;
    }

    public void ringPhone(View v) {
        phone_string = phone_number.getText().toString();
        if (phone_string.length() < 12) {
            Toast.makeText(getApplicationContext(),"Please enter valid phone number",Toast.LENGTH_LONG).show();
            return;
        }
        String tel = "tel:" + phone_string.replaceAll("[^0-9|\\+]", "");
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        //Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse(tel));
        try {
            startActivity(phoneIntent);
        } catch(Exception ex) {//android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(),"Cannot execute the call",Toast.LENGTH_SHORT).show();
        }
    }

    public void closeApp(View v) {
        MainActivity.this.finish();
    }
}
