package com.example.nagivator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class voyage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voyage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button startSailBtn = (Button) findViewById(R.id.startSailBtn);
        startSailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view) {
                startActivity(new Intent(voyage.this, activity_sailing_activity.class));
            }
        });


    }

}
