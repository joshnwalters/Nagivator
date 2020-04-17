package com.example.nagivator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NaggyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naggy);

        TextView textView = findViewById(R.id.textView);
        String naggy = getIntent().getStringExtra("naggy");
        textView.setText(naggy);
    }
}
