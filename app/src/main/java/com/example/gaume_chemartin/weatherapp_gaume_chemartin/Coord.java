package com.example.gaume_chemartin.weatherapp_gaume_chemartin;

/**
 * Created by louis on 27/02/2017.
 */

public class Coord {
    private float latitude;
    private float longitude;

    public Coord(float latitude, float longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
