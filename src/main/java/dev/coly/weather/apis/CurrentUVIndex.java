package dev.coly.weather.apis;

import dev.coly.weather.HttpHandler;
import dev.coly.weather.UVIndex;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Gregyyy on 27.03.2018.
 */
public class CurrentUVIndex{

    private Float latitude;
    private Float longitude;
    private UVIndex uvIndex;

    public CurrentUVIndex(){
    }

    public CurrentUVIndex parseContent(String url) throws IOException{
        String content = HttpHandler.getContentFromWebsite(url);
        JSONObject json = new JSONObject(content);

        latitude = json.getFloat("lat");
        longitude = json.getFloat("lon");
        UVIndex index = new UVIndex();
        index.setValue(json.getFloat("value"));
        index.setDate(json.getLong("date"));
        uvIndex = index;

        return this;
    }

    public CurrentUVIndex(Float latitude, Float longitude, UVIndex uvIndex){
        this.latitude = latitude;
        this.longitude = longitude;
        this.uvIndex = uvIndex;
    }

    public Float getLatitude(){
        return latitude;
    }

    public void setLatitude(Float latitude){
        this.latitude = latitude;
    }

    public Float getLongitude(){
        return longitude;
    }

    public void setLongitude(Float longitude){
        this.longitude = longitude;
    }

    public UVIndex getUvIndex(){
        return uvIndex;
    }

    public void setUvIndex(UVIndex uvIndex){
        this.uvIndex = uvIndex;
    }

    @Override
    public String toString(){
        return "CurrentUVIndex{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", uvIndex=" + uvIndex +
                '}';
    }
}

