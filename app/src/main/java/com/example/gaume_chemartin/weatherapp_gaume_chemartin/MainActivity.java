package com.example.gaume_chemartin.weatherapp_gaume_chemartin;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

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

        try {
            InputStream inputStream = getAssets().open("city_france.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder out = new StringBuilder();
            ArrayList<City> arrayCity = new ArrayList<>();
            String line;
            Gson g = new Gson();
            while ((line = reader.readLine()) != null) {
                City city = g.fromJson(line, City.class);
                arrayCity.add(city);
            }
            Log.i("JSON",out.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
