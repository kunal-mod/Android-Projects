package com.example.mystorageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String s = getFilesDir().getAbsolutePath();
        TextView textView = findViewById(R.id.tv);
        textView.setText(s);
    }
}