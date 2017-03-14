package com.example.gaume_chemartin.weatherapp_gaume_chemartin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class DetailsVille extends AppCompatActivity {

    public final static String API_KEY = "5a0b1491398087a10f95d2b4f1c9dd13";

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

        Intent intent = getIntent();
        City city = (City) intent.getParcelableExtra("VILLE");

        setTitle(city.getName());

        String url = "http://api.openweathermap.org/data/2.5/weather?id="+city.getId()+"&appid="+API_KEY;

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, // méthode : GET, POST, PUT, DELETE, etc
                url,
                new Response.Listener<String>() { // Listener appelé quand la requête renvoie 200
                    @Override
                    public void onResponse(String response) {
                        Log.i("response",response);
// Gestion de la réponse (ici un String)
                    }
                },
                new Response.ErrorListener() { // Listener appelé en cas d’erreur
                    @Override
                    public void onErrorResponse(VolleyError error) {
// Gestion de l’erreur
                    }
                });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}
