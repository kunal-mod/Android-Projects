package com.example.demoproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountriesArrayAdapter extends RecyclerView.Adapter<CountriesArrayAdapter.ViewHolder> {
    ArrayList<Countries> countries;
    Context context;
    CountriesArrayAdapter(Context context, ArrayList<Countries> countries){
        this.context = context;
        this.countries=countries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_countries_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView countryName = holder.countryName;
        TextView countryFood = holder.countryFood;
        ImageView image = holder.image;
        Countries currentCountry = countries.get(position);
        countryName.setText(currentCountry.getCountryName());
        countryFood.setText(currentCountry.getCountryFood());
        image.setImageResource(currentCountry.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"You clicked item: " + currentCountry.getCountryName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView countryName,countryFood;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.countryName);
            countryFood = itemView.findViewById(R.id.countryFood);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}
