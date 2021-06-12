package dev.coly.weather.apis;

import dev.coly.weather.HttpHandler;
import dev.coly.weather.UVIndex;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * Created by Gregyyy on 27.03.2018.
 */
public class ForecastUVIndex{

    private Float latitude;
    private Float longitude;
    private ArrayList<UVIndex> uvIndexes;

    public ForecastUVIndex(){
    }

    public ForecastUVIndex parseContent(String url) throws IOException{
        String content = HttpHandler.getContentFromWebsite(url);
        JSONObject json = new JSONObject(content.replaceFirst(Pattern.quote("["), "{[").replaceAll(Pattern.quote("]"), "]}"));

        Iterator<String> iterator = json.keys();
        while(iterator.hasNext()){
            System.out.println("Name: '" + iterator.next() + "'");
            /*latitude = json.getJSONObject("" + i).getFloat("lat");
            longitude = json.getJSONObject("" + i).getFloat("lon");
            UVIndex index = new UVIndex();
            index.setValue(json.getJSONObject("" + i).getFloat("value"));
            index.setDate(json.getJSONObject("" + i).getLong("date"));
            uvIndexes.add(index);*/
        }

        return this;
    }

    public ForecastUVIndex(Float latitude, Float longitude, ArrayList<UVIndex> uvIndexes){
        this.latitude = latitude;
        this.longitude = longitude;
        this.uvIndexes = uvIndexes;
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

    public ArrayList<UVIndex> getUvIndexes(){
        return uvIndexes;
    }

    public void setUvIndexes(ArrayList<UVIndex> uvIndexes){
        this.uvIndexes = uvIndexes;
    }

    @Override
    public String toString(){
        return "ForecastUVIndex{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", uvIndexes=" + uvIndexes +
                '}';
    }
}

