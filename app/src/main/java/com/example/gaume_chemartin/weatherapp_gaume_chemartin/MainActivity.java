package com.example.gaume_chemartin.weatherapp_gaume_chemartin;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<City> arrayCity = new ArrayList<>();

        try {
            InputStream inputStream = getAssets().open("city_france.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder out = new StringBuilder();
            String line;
            Gson g = new Gson();
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }

            String stringCities = out.toString();

            arrayCity = g.fromJson(stringCities, new TypeToken<ArrayList<City>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CityAdapter(arrayCity, new CityAdapter.OnCityListener() {
            @Override
            public void onCityClick(City city) {
                // Action lors du clic sur un item de la liste
                Intent intent = new Intent(MainActivity.this, DetailsVille.class);
                intent.putExtra("VILLE", (Parcelable) city);
                startActivity(intent);
            }

            @Override
            public void onCityLongClick(City city) {
                // Autre action lors du clic long sur un item de la liste
            }
        }));




    }
}
