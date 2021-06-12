package dev.coly.weather.apis;

import dev.coly.weather.HttpHandler;
import dev.coly.weather.JSONHelper;
import dev.coly.weather.Station;
import dev.coly.weather.WeatherState;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Gregyyy on 02.12.2017.
 */
public class CurrentWeather {

    private Station station;
    private WeatherState weatherState;
    private long timeOfData;

    public CurrentWeather(){
    }

    public CurrentWeather parseContent(String url) throws IOException{
        String content = HttpHandler.getContentFromWebsite(url);
        JSONObject json = new JSONObject(content);
        Station station = new Station();
        WeatherState weatherState = new WeatherState();

        this.setTimeOfData(json.getLong("dt"));

        station.setName(json.getString("name"));
        station.setId(json.getInt("id"));
        station.setLongitude(JSONHelper.getDouble(json, "coord", "lon"));
        station.setLatitude(JSONHelper.getDouble(json, "coord", "lat"));
        station.setCountry(JSONHelper.getString(json, "sys", "country"));
        station.setSunrise(JSONHelper.getLong(json, "sys", "sunrise"));
        station.setSunset(JSONHelper.getLong(json, "sys", "sunset"));
        this.setStation(station);

        weatherState.setWeather(JSONHelper.getString(json, "weather", 0, "main"));
        weatherState.setWeatherDescription(JSONHelper.getString(json, "weather", 0, "description"));
        weatherState.setWeatherId(JSONHelper.getInt(json, "weather", 0, "id"));
        weatherState.setWeatherIcon(JSONHelper.getString(json, "weather", 0, "icon"));
        weatherState.setTemperature(JSONHelper.getDouble(json, "main", "temp"));
        weatherState.setTemperatureMin(JSONHelper.getDouble(json, "main", "temp_min"));
        weatherState.setTemperatureMax(JSONHelper.getDouble(json, "main", "temp_max"));
        weatherState.setPressure(JSONHelper.getInt(json, "main", "pressure"));
        weatherState.setHumidity(JSONHelper.getInt(json, "main", "humidity"));
        weatherState.setWindSpeed(JSONHelper.getDouble(json, "wind", "speed"));
        weatherState.setWindDegree(JSONHelper.getInt(json, "wind", "deg"));
        weatherState.setCloudiness(JSONHelper.getInt(json, "clouds", "all"));
        weatherState.setSeaLevel(JSONHelper.getDouble(json, "main", "sea_level"));
        weatherState.setGroundLevel(JSONHelper.getDouble(json, "main", "grnd_level"));
        this.setWeatherState(weatherState);

        return this;
    }

    public CurrentWeather(Station station, WeatherState weatherState, long timeOfData){
        this.station = station;
        this.weatherState = weatherState;
        this.timeOfData = timeOfData;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public WeatherState getWeatherState() {
        return weatherState;
    }

    public void setWeatherState(WeatherState weatherState) {
        this.weatherState = weatherState;
    }

    public long getTimeOfData(){
        return timeOfData;
    }

    public void setTimeOfData(long timeOfData){
        this.timeOfData = timeOfData;
    }

    @Override
    public String toString(){
        return "CurrentWeather{" +
                "station=" + station +
                ", weatherState=" + weatherState +
                ", timeOfData=" + timeOfData +
                '}';
    }

    public JSONObject toJSON(){
        return new JSONObject().append("station", station.toJSON()).append("weatherState", weatherState.toJSON())
                .append("timeOfDate", timeOfData);
    }
}
