package com.example.gaume_chemartin.weatherapp_gaume_chemartin;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


/**
 * Created by romain on 12/03/17.
 */

public class CityHolder extends RecyclerView.ViewHolder{
    private TextView nomVille;


    public CityHolder(View itemView) {
        super(itemView);
        nomVille = (TextView) itemView.findViewById(R.id.villeName);
    }

    public void bind(final City city, final CityAdapter.OnCityListener listener){
        // Affectation du listener
        if(listener != null) {
            nomVille.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onCityClick(city);
                }
            });

            nomVille.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onCityLongClick(city);
                    return false;
                }
            });
        }
        nomVille.setText(city.getName());
    }
}
