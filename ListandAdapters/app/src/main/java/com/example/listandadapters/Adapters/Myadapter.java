package com.example.listandadapters.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listandadapters.CountriesFramework.Countries;
import com.example.listandadapters.CountryRead;
import com.example.listandadapters.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.viewHolder>{

    ArrayList<Countries> list;
    Context context;

    public Myadapter(Context context, ArrayList<Countries> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.countries_adapter_view, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Countries country = list.get(position);
        holder.country.setText(country.getName());
        holder.capital.setText(country.getCapital());
//        holder.imageView.setImageResource(country.getImage());
        Picasso.get()
                .load(country.getImage())
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CountryRead.class);
                intent.putExtra("url",country.getUrl());
                context.startActivity(intent);
            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, country.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView capital,country;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            capital = itemView.findViewById(R.id.capital);
            country = itemView.findViewById(R.id.country);

        }
    }
}
