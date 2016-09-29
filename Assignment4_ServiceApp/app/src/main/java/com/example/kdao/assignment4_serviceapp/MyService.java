package com.example.kdao.assignment4_serviceapp;

import java.net.URL;
import android.app.IntentService;
import android.content.Intent;
import android.app.Activity;
import java.io.*;
import android.os.*;
import java.net.URLConnection;

/**
 * Created by kdao on 9/22/16.
 */
public class MyService extends IntentService {
    private int result = Activity.RESULT_CANCELED;
    public static final String URL = "URL";
    public static final String FILE_NAME = "FILE_NAME";
    public static final String FILE_PATH = "FILE_PATH";
    public static final String RESULT = "Result";
    public static final String NOTIFICATION = "DOWNLOAD_FILE";

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int count;
        String urlPath = intent.getStringExtra(URL);
        String fileName = intent.getStringExtra(FILE_NAME);
        File output = new File(Environment.getExternalStorageDirectory(), fileName);
        if (output.exists())    {
            output.delete();
        }
        InputStream stream = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL(urlPath);
            URLConnection con = url.openConnection();
            con.connect();
            stream = new BufferedInputStream(url.openStream());
            fos = new FileOutputStream(output.getPath());
            byte data[] = new byte[1024];
            while ((count = stream.read(data)) != -1) {
                fos.write(data, 0, count);
            }
            fos.flush();
            fos.close();
            stream.close();
            result = Activity.RESULT_OK;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        broastcastResult(output.getAbsolutePath(), result);
    }

    private void broastcastResult(String outputPath, int result)  {
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(FILE_PATH, outputPath);
        intent.putExtra(RESULT, result);
        sendBroadcast(intent);
    }
}

