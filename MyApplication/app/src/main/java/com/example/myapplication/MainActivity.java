package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edText1,edText2;
        TextView textView,textView2;
        Button button,button4,button2,button3;
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        edText1 = findViewById(R.id.edText1);
        edText2 = findViewById(R.id.edText2);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        button.setOnClickListener(v -> {
            textView.setText("+");
            int a,b,c;
            a=Integer.parseInt(edText1.getText().toString());
            b=Integer.parseInt(edText2.getText().toString());
            c=a+b;
            String ans = "Ans = "+c;
            textView2.setText(ans);
        });

        button2.setOnClickListener(v -> {
            textView.setText("-");
            int a,b,c;
            a=Integer.parseInt(edText1.getText().toString());
            b=Integer.parseInt(edText2.getText().toString());
            c=a-b;
            String ans = "Ans = "+c;
            textView2.setText(ans);
        });
        button3.setOnClickListener(v -> {
            textView.setText("*");
            int a,b,c;
            a=Integer.parseInt(edText1.getText().toString());
            b=Integer.parseInt(edText2.getText().toString());
            c=a*b;
            String ans = "Ans = "+c;
            textView2.setText(ans);
        });
        button4.setOnClickListener(v -> {
            textView.setText("/");
            int a,b,c;
            a=Integer.parseInt(edText1.getText().toString());
            b=Integer.parseInt(edText2.getText().toString());
            c=a/b;
            String ans = "Ans = "+c;
            textView2.setText(ans);
        });
    }
}