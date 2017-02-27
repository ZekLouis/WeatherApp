package com.example.gaume_chemartin.weatherapp_gaume_chemartin;

/**
 * Created by louis on 27/02/2017.
 */

public class City {
    private int _id;
    private String name;
    private String country;
    private Coord coord;

    public City(Coord coord, int id, String name, String country) {
        this.coord = coord;
        this._id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + _id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", coord=" + coord +
                '}';
    }
}
