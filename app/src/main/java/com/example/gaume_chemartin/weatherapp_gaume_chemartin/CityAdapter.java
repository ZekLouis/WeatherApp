package com.example.gaume_chemartin.weatherapp_gaume_chemartin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by romain on 12/03/17.
 */

public class CityAdapter extends RecyclerView.Adapter<CityHolder>{

    private OnCityListener listener;
    ArrayList<City> liste = new ArrayList<>();

    public interface OnCityListener {
        void onCityClick(City city);
        void onCityLongClick(City city);
    }

    public CityAdapter(ArrayList<City> cities, OnCityListener listener){
        this.listener = listener;
        this.liste = cities;
    }

    @Override
    public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new CityHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CityHolder holder, int position) {
        holder.bind(liste.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }
}
