package com.example.nagivator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class activity_sailing_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sailing_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);









         Runnable r = new Runnable() {

        @Override
        public void run() {
        startActivity(new Intent(activity_sailing_activity.this, afterSession.class));
        }
        };

         Handler h = new Handler();
         h.postDelayed(r, 900000);




    }

}
