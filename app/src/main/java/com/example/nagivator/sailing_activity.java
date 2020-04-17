package com.example.nagivator;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import java.util.Timer;
import java.util.TimerTask;


public class sailing_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sailing_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        class MyTimerTask extends TimerTask {
            String nag = "Are Ye Still On Yer Course?";
            long[] l = {10L, 10L, 10L};
            @Override
            public void run() {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        sailing_activity.this
                )
                        .setSmallIcon(R.drawable.ic_feedback_black_24dp)
                        .setContentTitle("Naggy Notification")
                        .setContentText(nag)
                        .setAutoCancel(true)
                        .setLights(000000, 10, 10)
                        .setVibrate(l)
                        .setPriority(1)
                        .setTimeoutAfter(500);
                Intent intent = new Intent(sailing_activity.this, NaggyActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                PendingIntent pendingIntent = PendingIntent.getActivity(sailing_activity.this,
                        0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager)getSystemService (
                        Context.NOTIFICATION_SERVICE
                );

                notificationManager.notify(0, builder.build());



            }
        }

        MyTimerTask myTask = new MyTimerTask();
        Timer timer = new Timer();
        timer.schedule(myTask, 0, 600);










        Runnable r = new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(sailing_activity.this, afterSession.class));
            }
        };

        Handler h = new Handler();
        h.postDelayed(r, 900000);

        Button endSess = (Button) findViewById(R.id.endSess);
        endSess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view) {
                startActivity(new Intent(sailing_activity.this, afterSession.class));
            }
        });




    }

}
