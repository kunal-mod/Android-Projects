package com.example.listandadapters;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.listandadapters.Adapters.Myadapter;
import com.example.listandadapters.CountriesFramework.Countries;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Countries> countries = new ArrayList<>();
//        countries.add(new Countries("India","Delhi",R.drawable.india));
//        countries.add(new Countries("Brazil","Kya pata",R.drawable.brazil));
//        countries.add(new Countries("Germany","Berlin",R.drawable.germany));
//        countries.add(new Countries("Italy","Paris",R.drawable.italy));
//        countries.add(new Countries("South Africa","Kale log",R.drawable.south_africa));
//        countries.add(new Countries("United Kingdom","London",R.drawable.united_kingdom));
//        countries.add(new Countries("United States of America","Washington DC",R.drawable.united_states));
//        countries.add(new Countries("India","Delhi",R.drawable.india));
//        countries.add(new Countries("Brazil","Kya pata",R.drawable.brazil));
//        countries.add(new Countries("Germany","Berlin",R.drawable.germany));
//        countries.add(new Countries("Italy","Paris",R.drawable.italy));
//        countries.add(new Countries("South Africa","Kale log",R.drawable.south_africa));
//        countries.add(new Countries("United Kingdom","London",R.drawable.united_kingdom));
//        countries.add(new Countries("United States of America","Washington DC",R.drawable.united_states));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        Myadapter myadapter = new Myadapter(MainActivity.this,countries);
        recyclerView.setAdapter(myadapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
//        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(manager);

//        GridLayoutManager gManager = new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(gManager);

        FirebaseDatabase.getInstance().getReference().child("countries").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                countries.clear();
                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    Countries country = snapshot1.getValue(Countries.class);
                    countries.add(country);
                }
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}