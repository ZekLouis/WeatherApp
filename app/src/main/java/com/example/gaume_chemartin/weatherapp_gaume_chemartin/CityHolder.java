package com.example.gaume_chemartin.weatherapp_gaume_chemartin;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


/**
 * Created by romain on 12/03/17.
 */

public class CityHolder extends RecyclerView.ViewHolder{
    private TextView nomVille;
    private City city;


    public CityHolder(View itemView) {
        super(itemView);
        nomVille = (TextView) itemView.findViewById(R.id.villeName);
    }

    public void bind(City city){
        nomVille.setText(city.getName());
    }
}
