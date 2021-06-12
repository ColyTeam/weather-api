package dev.coly.weather.apis;

import dev.coly.weather.HttpHandler;
import dev.coly.weather.Station;
import dev.coly.weather.WeatherState;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Gregyyy on 03.12.2017.
 */
public class ForecastWeather {

    private Station station;
    private HashMap<Long, WeatherState> weatherStates = new HashMap<>();

    public ForecastWeather(){
    }

    public ForecastWeather parseContent(String url) throws IOException{
        String content = HttpHandler.getContentFromWebsite(url);
        JSONObject json = new JSONObject(content);
        Station station = new Station();
        HashMap<Long, WeatherState> weatherStates = new HashMap<>();

        station.setName(json.getJSONObject("city").getString("name"));
        station.setId(json.getJSONObject("city").getInt("id"));
        station.setLongitude(json.getJSONObject("city").getJSONObject("coord").getDouble("lon"));
        station.setLatitude(json.getJSONObject("city").getJSONObject("coord").getDouble("lat"));
        station.setCountry(json.getJSONObject("city").getString("country"));
        this.setStation(station);

        int count = json.getInt("cnt");
        for(int i = 0; i < count; i++){
            WeatherState weatherState = new WeatherState();

            weatherState.setWeather(json.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("main"));
            weatherState.setWeatherDescription(json.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description"));
            weatherState.setWeatherId(json.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getInt("id"));
            weatherState.setWeatherIcon(json.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("icon"));
            weatherState.setTemperature(json.getJSONArray("list").getJSONObject(i).getJSONObject("main").getDouble("temp"));
            weatherState.setTemperatureMin(json.getJSONArray("list").getJSONObject(i).getJSONObject("main").getDouble("temp_min"));
            weatherState.setTemperatureMax(json.getJSONArray("list").getJSONObject(i).getJSONObject("main").getDouble("temp_max"));
            weatherState.setPressure(json.getJSONArray("list").getJSONObject(i).getJSONObject("main").getInt("pressure"));
            weatherState.setHumidity(json.getJSONArray("list").getJSONObject(i).getJSONObject("main").getInt("humidity"));
            weatherState.setWindSpeed(json.getJSONArray("list").getJSONObject(i).getJSONObject("wind").getDouble("speed"));
            weatherState.setWindDegree(json.getJSONArray("list").getJSONObject(i).getJSONObject("wind").getInt("deg"));
            weatherState.setCloudiness(json.getJSONArray("list").getJSONObject(i).getJSONObject("clouds").getInt("all"));
            try{ weatherState.setSeaLevel(json.getJSONObject("main").getDouble("sea_level")); }catch(JSONException ignore){}
            try{ weatherState.setGroundLevel(json.getJSONObject("main").getDouble("grnd_level")); }catch(JSONException ignore){}

            weatherStates.put(json.getJSONArray("list").getJSONObject(i).getLong("dt"), weatherState);
        }

        this.setWeatherStates(weatherStates);
        return this;
    }

    public ForecastWeather(Station station, HashMap<Long, WeatherState> weatherStates){
        this.station = station;
        this.weatherStates = weatherStates;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public HashMap<Long, WeatherState> getWeatherStates() {
        return weatherStates;
    }

    public void setWeatherStates(HashMap<Long, WeatherState> weatherStates) {
        this.weatherStates = weatherStates;
    }

    @Override
    public String toString() {
        return "ForecastWeather{" +
                "station=" + station +
                ", weatherStates=" + weatherStates +
                '}';
    }

    public JSONObject toJSON(){
        return new JSONObject().append("station", station.toJSON()).append("weatherStates", new JSONObject(weatherStates));
    }
}
