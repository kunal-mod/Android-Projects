package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.demoproject.FragmentFolder.FirstFragment;
import com.example.demoproject.FragmentFolder.SecondFragment;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView fragmentOne = findViewById(R.id.fragmentOne);
        TextView fragmentTwo = findViewById(R.id.fragmentTwo);
        TextView fragCount = findViewById(R.id.fragCount);
        fragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment firstFragment = new FirstFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.replaceLayout, firstFragment);
//                transaction.addToBackStack("firstFragment");
                transaction.commit();
            }
        });
        fragmentTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.replaceLayout, secondFragment);
//                transaction.addToBackStack("SecondFragment");
                transaction.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.replaceLayout);
        if(fragment!=null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.remove(fragment);
            transaction.commit();
        }
        else
            super.onBackPressed();
    }
}