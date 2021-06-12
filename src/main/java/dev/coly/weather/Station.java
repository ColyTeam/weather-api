package dev.coly.weather;

import org.json.JSONObject;

/**
 * Created by Gregyyy on 02.12.2017.
 */
public class Station {

    private String name;
    private int id;
    private double longitude;
    private double latitude;
    private String country;
    private Long sunrise;
    private Long sunset;

    public Station() {
    }

    public Station(String name, int id, double longitude, double latitude, String country, Long sunrise, Long sunset) {
        this.name = name;
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }

    public JSONObject toJSON() {
        return new JSONObject().append("name", name).append("id", id).append("longitude", longitude)
                .append("latitude", latitude).append("country", country).append("sunrise", sunrise).append("sunset", sunset);
    }
}
