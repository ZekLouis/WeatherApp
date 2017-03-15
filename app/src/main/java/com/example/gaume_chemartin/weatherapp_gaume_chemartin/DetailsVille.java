package com.example.gaume_chemartin.weatherapp_gaume_chemartin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DetailsVille extends AppCompatActivity {

    public final static String API_KEY = "5a0b1491398087a10f95d2b4f1c9dd13";
    CityWeather cityWeather ;
    TextView idVille;
    TextView temp;
    TextView pressure;
    TextView humidity;
    TextView temp_min;
    TextView temp_max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_ville);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        idVille = (TextView) findViewById(R.id.idVille);
        temp = (TextView) findViewById(R.id.temp);
        pressure = (TextView) findViewById(R.id.pressure);
        humidity = (TextView) findViewById(R.id.humidity);
        temp_min = (TextView) findViewById(R.id.temp_min);
        temp_max = (TextView) findViewById(R.id.temp_max);


        Intent intent = getIntent();
        City city = (City) intent.getParcelableExtra("VILLE");
        CityWeather cityWeather ;

        setTitle(city.getName());

        String url = "http://api.openweathermap.org/data/2.5/weather?id="+city.getId()+"&appid="+API_KEY;


        Log.i("URL",url);

        GsonRequest<CityWeather> request = new GsonRequest<>(url, CityWeather.class, null,
                new Response.Listener<CityWeather>() {
                    @Override
                    public void onResponse(CityWeather city) {

                        idVille.setText(city.getId());
                        temp.setText(String.valueOf(city.getMain().get("temp").getAsDouble()));
                        pressure.setText(String.valueOf(city.getMain().get("pressure").getAsInt()));
                        humidity.setText(String.valueOf(city.getMain().get("humidity").getAsInt()));
                        temp_min.setText(String.valueOf(city.getMain().get("temp_min").getAsDouble()));
                        temp_max.setText(String.valueOf(city.getMain().get("temp_max").getAsDouble()));


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(DetailsVille.this, "Erreur", Toast.LENGTH_LONG).show();
            }
        });


        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
