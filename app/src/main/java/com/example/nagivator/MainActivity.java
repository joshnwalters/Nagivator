package com.example.nagivator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ImageView avatarImageView = (ImageView) findViewById(R.id.avatarImageView);
        Button setSailBtn = (Button) findViewById(R.id.startSailBtn);
        setSailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view) {
                startActivity(new Intent(MainActivity.this, voyage.class));
            }
        });

        Button viewLogBtn = (Button) findViewById(R.id.viewLogBtn);
        Button shipInfoBtn = (Button) findViewById(R.id.chartCourseBtn);
        Button commodoreBtn = (Button) findViewById(R.id.commodoreBtn);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
