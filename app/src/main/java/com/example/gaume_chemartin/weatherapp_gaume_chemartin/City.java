package com.example.gaume_chemartin.weatherapp_gaume_chemartin;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by louis on 27/02/2017.
 */

public class City implements Parcelable{
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

    protected City(Parcel in) {
        _id = in.readInt();
        name = in.readString();
        country = in.readString();
        coord = in.readParcelable(Coord.class.getClassLoader());
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(name);
        dest.writeString(country);
        dest.writeParcelable(coord, flags);
    }
}
