package com.example.multithreading;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class ThreadClass extends View {

    Thread  m_objThread;
    TextView textView;

    public ThreadClass(Context context) {
        super(context);

        textView = new TextView(context);
        textView.setText("ajith");
        m_objThread=new Thread(new Runnable() {
            public void run() {
                for(int i=1;i<100;i++) {
                    try {
                        counter(i);
                        Thread.sleep(1000);
                    } catch(Exception  e) {
                    }
                }
            }
        });
        m_objThread.start();
    }

    public void counter(int j) {
        textView.setText(String.valueOf(j));
        textView.refreshDrawableState();
    }

}
