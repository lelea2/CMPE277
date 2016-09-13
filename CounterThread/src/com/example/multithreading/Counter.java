package com.example.multithreading;

import android.os.Handler;
import android.os.Message;

public class Counter {

    ICounterEvents m_CountChangedListener;
    public static Thread m_objThread;

    public Counter() {
        m_objThread=new Thread(new Runnable() {
            public void run() {
                for(int i=1;i<100;i=i+1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    Message msg=Message.obtain();
                    msg.obj=i;
                    mHandler.sendMessage(msg);
                }
            }
        });
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int iCount=(Integer) msg.obj;
            m_CountChangedListener.countchanged(iCount);
        }
    };


    public void setCountListener(ICounterEvents countChangedListener){
        m_CountChangedListener=countChangedListener;
    }

    public void start() {
        m_objThread.start();
    }



}
