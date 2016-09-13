package com.example.multithreading;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity implements ICounterEvents {


    TextView setv;
    Exception m_ex;
    Counter m_counter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setv=(TextView)findViewById(R.id.textViewCounter);
        setv.setText("counter");
    }

    public void countchanged(int count) {
        try {
            setv.setText(""+ count);
        }
        catch(Exception ex){
            m_ex=ex;
        }
    }

    public void startCounter(View view) {
        m_counter=new Counter();
        m_counter.setCountListener(this);
        m_counter.start();
    }

  }



