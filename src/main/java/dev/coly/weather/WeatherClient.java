package dev.coly.weather;

import dev.coly.weather.apis.CurrentUVIndex;
import dev.coly.weather.apis.CurrentWeather;
import dev.coly.weather.apis.ForecastUVIndex;
import dev.coly.weather.apis.ForecastWeather;

import java.io.IOException;

/**
 * Created by Gregyyy on 02.12.2017.
 */
public class WeatherClient {

    private String API_KEY;

    public WeatherClient(String API_KEY){
        this.API_KEY = API_KEY;
    }

    public CurrentWeather getCurrentWeatherByCoordinates(double latitude, double longitude, UnitType unitType, String langCode) throws IOException{
        return getCurrentWeatherByURL("http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&APPID=" + API_KEY + addUnit(unitType) + "&lang=" + langCode);
    }

    public CurrentWeather getCurrentWeatherByCityID(String cityID, UnitType unitType, String langCode) throws IOException{
        return getCurrentWeatherByURL("http://api.openweathermap.org/data/2.5/weather?id=" + cityID + "&APPID=" + API_KEY + addUnit(unitType) + "&lang=" + langCode);
    }

    public CurrentWeather getCurrentWeatherByCityName(String cityName, UnitType unitType, String langCode) throws IOException{
        return getCurrentWeatherByURL("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&APPID=" + API_KEY + addUnit(unitType) + "&lang=" + langCode);
    }

    public CurrentWeather getCurrentWeatherByURL(String url) throws IOException {
        return new CurrentWeather().parseContent(url);
    }
    public ForecastWeather getForecastWeatherByCoordinates(double latitude, double longitude, UnitType unitType, String langCode) throws IOException{
        return getForecastWeatherByURL("http://api.openweathermap.org/data/2.5/forecast?lat=" + latitude + "&lon=" + longitude + "&APPID=" + API_KEY + addUnit(unitType) + "&lang=" + langCode);
    }

    public ForecastWeather getForecastWeatherByCityID(String cityID, UnitType unitType, String langCode) throws IOException{
        return getForecastWeatherByURL("http://api.openweathermap.org/data/2.5/forecast?id=" + cityID + "&APPID=" + API_KEY + addUnit(unitType) + "&lang=" + langCode);
    }

    public ForecastWeather getForecastWeatherByCityName(String cityName, UnitType unitType, String langCode) throws IOException{
        return getForecastWeatherByURL("http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&APPID=" + API_KEY + addUnit(unitType) + "&lang=" + langCode);
    }

    public ForecastWeather getForecastWeatherByURL(String url) throws IOException {
        return new ForecastWeather().parseContent(url);
    }

    public CurrentUVIndex getCurrentUVByURL(String url) throws IOException {
        return new CurrentUVIndex().parseContent(url);
    }

    public CurrentUVIndex getCurrentUVByCoordinates(double latitude, double longitude, UnitType unitType, String langCode) throws IOException{
        return getCurrentUVByURL("http://api.openweathermap.org/data/2.5/uvi?lat=" + latitude + "&lon=" + longitude + "&APPID=" + API_KEY + addUnit(unitType) + "&lang=" + langCode);
    }

    public ForecastUVIndex getForecastUVByURL(String url) throws IOException {
        return new ForecastUVIndex().parseContent(url);
    }

    public ForecastUVIndex getForecastUVByCoordinates(double latitude, double longitude, UnitType unitType, String langCode) throws IOException{
        return getForecastUVByURL("http://api.openweathermap.org/data/2.5/uvi/forecast?lat=" + latitude + "&lon=" + longitude + "&APPID=" + API_KEY + addUnit(unitType) + "&lang=" + langCode);
    }

    public String addUnit(UnitType unitType){
        if(unitType == UnitType.Standard){
            return "";
        }
        if(unitType == UnitType.Metric){
            return "&units=metric";
        }
        if(unitType == UnitType.Imperial){
            return "&units=imperial";
        }
        return "";
    }

}
