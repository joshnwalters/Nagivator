package com.example.nagivator;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Timer;
import java.util.TimerTask;


public class activity_sailing_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String nag = "Are Ye Still On Yer Course?";
        long[] l = {10L, 10L, 10L};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sailing_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        createNotificationChannel();

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(
                activity_sailing_activity.this, "naggy"
        )
                .setSmallIcon(R.drawable.ic_feedback_black_24dp)
                .setContentTitle("Naggy Notification")
                .setContentText(nag)
                .setAutoCancel(true)
                .setLights(000000, 10, 10)
                .setVibrate(l)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setTimeoutAfter(500);


         final NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);


        class MyTimerTask extends TimerTask {

            @Override
            public void run() {

                notificationManager.notify(0, builder.build());




            }
        }

        MyTimerTask myTask = new MyTimerTask();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(myTask, 180000, 180000);

        Runnable r = new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(activity_sailing_activity.this, afterSession.class));
            }
        };

        Handler h = new Handler();
        h.postDelayed(r, 900000);

        Button endSess = (Button) findViewById(R.id.endSess);
        endSess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view) {
                startActivity(new Intent(activity_sailing_activity.this, afterSession.class));
            }
        });
    }

        private void createNotificationChannel(){
                CharSequence name = "naggyChannel";
                String description = "Nag Channel";
                int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("naggy", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);


        }







}
