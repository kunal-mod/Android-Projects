package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Countries> countries = new ArrayList<Countries>();
        countries.add(new Countries("India","Roti Sabji",R.drawable.india));
        countries.add(new Countries("United Kingdom","Bottle-o-water",R.drawable.united_kingdom));
        countries.add(new Countries("Brazil","Taco",R.drawable.brazil));
        countries.add(new Countries("Italy","Pizza",R.drawable.italy));
        countries.add(new Countries("Germany","Vodka",R.drawable.germany));
        countries.add(new Countries("South Africa","Bhukke Nange",R.drawable.south_africa));
        countries.add(new Countries("United States","Cocain",R.drawable.united_states));
        countries.add(new Countries("India","Roti Sabji",R.drawable.india));
        countries.add(new Countries("United Kingdom","Bottle-o-water",R.drawable.united_kingdom));
        countries.add(new Countries("Brazil","Taco",R.drawable.brazil));
        countries.add(new Countries("Italy","Pizza",R.drawable.italy));
        countries.add(new Countries("Germany","Vodka",R.drawable.germany));
        countries.add(new Countries("South Africa","Bhukke Nange",R.drawable.south_africa));
        countries.add(new Countries("United States","Cocain",R.drawable.united_states));

        RecyclerView recyclerView = findViewById(R.id.rView);
        CountriesArrayAdapter adapter = new CountriesArrayAdapter(this,countries);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }
}