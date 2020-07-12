package com.clonedchris.timetracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.time.LocalTime;

public class StartActivity extends AppCompatActivity{
    private static final String TAG = "StartActivity";
    public volatile boolean isrunning = false;
    public TextView timer;
    public Thread test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        timer = findViewById(R.id.current_time);
    }

    public void stopTimer(View view) {
        isrunning = false;
    }

    public void startTimer(View view) {
        isrunning = true;

        final long start = System.currentTimeMillis();

         test = new Thread() {
             @Override
             public void run() {
                 while (isrunning) {
                     final long current = (System.currentTimeMillis() - start) / 1000;
                     String a = Long.toString(current);
                     Log.d(TAG, a);

                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                             timer.setText(timeToString(current));
                         }
                     });

                     try {
                         Thread.sleep(100);
                     } catch (InterruptedException e) {

                     }
                 }
             }
         };

         test.start();
    }

    public static String timeToString(long time){
        long seconds = 0;
        long minutes = 0;
        long hours = 0;

        String timeString = "";

        if (time/3600 > 0){
            hours = time/3600;
            time = time - (hours * 3600);
            minutes = time/60;
            seconds = time - (minutes * 60);
        } else if (time/60 > 0){
            minutes = time/60;
            seconds = time - (minutes * 60);
        } else {
            seconds = time;
        }

        timeString += Long.toString(hours) + ":" + Long.toString(minutes) + ":" + Long.toString(seconds);

        return timeString;
    }


}

