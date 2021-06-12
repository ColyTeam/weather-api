package dev.coly.weather.test;

import dev.coly.weather.UnitType;
import dev.coly.weather.WeatherClient;
import dev.coly.weather.apis.CurrentWeather;
import dev.coly.weather.apis.ForecastWeather;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Gregyyy on 30.10.2018.
 */
public class ClientTest {

    private WeatherClient weatherClient;
    private final String API_KEY = "79500252717c5f7c7287965ff1f1931f";

    public ClientTest(){
        weatherClient = new WeatherClient("79500252717c5f7c7287965ff1f1931f");
    }

    private WeatherClient getWeatherClient(){
        return weatherClient;
    }

    @Test
    public void testGetWeatherClient(){
        Assert.assertNotNull(getWeatherClient());
    }

    @Test
    public void testGetCurrentWeatherByCoordinates(){
        try{
            CurrentWeather currentWeather = weatherClient.getCurrentWeatherByCoordinates(54.09, 12.13, UnitType.Metric, "DE");
            Assert.assertNotNull(currentWeather);
            System.out.println("Current Weather by Coordinates");
            System.out.println(currentWeather.toString());
        }catch(IOException e){
            Assert.fail();
        }
    }
    
    @Test
    public void testGetCurrentWeatherByCityID(){
        try{
            CurrentWeather currentWeather = weatherClient.getCurrentWeatherByCityID("2844588", UnitType.Metric, "DE");
            Assert.assertNotNull(currentWeather);
            System.out.println("Current Weather by City ID");
            System.out.println(currentWeather.toString());
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test
    public void testGetCurrentWeatherByCityName(){
        try{
            CurrentWeather currentWeather = weatherClient.getCurrentWeatherByCityName("Berlin", UnitType.Metric, "DE");
            Assert.assertNotNull(currentWeather);
            Assert.assertNotNull(currentWeather.getWeatherState());
            Assert.assertNotNull(currentWeather.getWeatherState().getWeather());
            System.out.println("Current Weather by City Name");
            System.out.println(currentWeather.toString());
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test
    public void testGetCurrentWeatherByURL() {
        try{
            CurrentWeather currentWeather = weatherClient.getCurrentWeatherByURL("http://api.openweathermap.org/data/2.5/weather?id=2844588&APPID=" + API_KEY + weatherClient.addUnit(UnitType.Metric) + "&lang=DE");
            Assert.assertNotNull(currentWeather);
            System.out.println("Current Weather by URL");
            System.out.println(currentWeather.toString());
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test
    public void testGetForecastWeatherByCoordinates(){
        try{
            ForecastWeather forecastWeather = weatherClient.getForecastWeatherByCoordinates(54.09, 12.13, UnitType.Metric, "DE");
            Assert.assertNotNull(forecastWeather);
            System.out.println("Forecast Weather by Coordinates");
            System.out.println(forecastWeather.toString());
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test
    public void testGetForecastWeatherByCityID(){
        try{
            ForecastWeather forecastWeather = weatherClient.getForecastWeatherByCityID("2844588", UnitType.Metric, "DE");
            Assert.assertNotNull(forecastWeather);
            System.out.println("Forecast Weather by City ID");
            System.out.println(forecastWeather.toString());
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test
    public void testGetForecastWeatherByCityName(){
        try{
            ForecastWeather forecastWeather = weatherClient.getForecastWeatherByCityName("Rostock", UnitType.Metric, "DE");
            Assert.assertNotNull(forecastWeather);
            System.out.println("Forecast Weather by City Name");
            System.out.println(forecastWeather.toString());
        }catch(IOException e){
            Assert.fail(e.toString());
        }
    }

    @Test
    public void testGetForecastWeatherByURL(){
        try{
            ForecastWeather forecastWeather = weatherClient.getForecastWeatherByURL("http://api.openweathermap.org/data/2.5/forecast?id=2844588&APPID=" + API_KEY + weatherClient.addUnit(UnitType.Metric) + "&lang=DE");
            Assert.assertNotNull(forecastWeather);
            System.out.println("Forecast Weather by URL");
            System.out.println(forecastWeather.toString());
        }catch(IOException e){
            Assert.fail();
        }
    }

    /*
    NOT IN USE. BUGGY.
    @Test
    public void testGetCurrentUVByURL(){
        try{
            CurrentUVIndex currentUVIndex = weatherClient.getCurrentUVByURL("http://api.openweathermap.org/data/2.5/uvi?id=2844588&APPID=" + API_KEY + weatherClient.addUnit(UnitType.Metric) + "&lang=DE");
            Assert.assertNotNull(currentUVIndex);
            System.out.println("Current UV Index by URL");
            System.out.println(currentUVIndex.toString());
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test
    public void testGetCurrentUVByCoordinates(){
        try{
            CurrentUVIndex currentUVIndex = weatherClient.getCurrentUVByCoordinates(54.09, 12.13, UnitType.Metric, "DE");
            Assert.assertNotNull(currentUVIndex);
            System.out.println("Current UV Index by Coordinates");
            System.out.println(currentUVIndex.toString());
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test
    public void testGetForecastUVByURL(){
        try{
            ForecastUVIndex forecastUVIndex = weatherClient.getForecastUVByURL("http://api.openweathermap.org/data/2.5/uvi?id=2844588&APPID=" + API_KEY + weatherClient.addUnit(UnitType.Metric) + "&lang=DE");
            Assert.assertNotNull(forecastUVIndex);
            System.out.println("Forecast UV Index by URL");
            System.out.println(forecastUVIndex.toString());
        }catch(IOException e){
            Assert.fail();
        }
    }

    @Test
    public void testGetForecastUVByCoordinates(){
        try{
            ForecastUVIndex forecastUVIndex = weatherClient.getForecastUVByCoordinates(54.09, 12.13, UnitType.Metric, "DE");
            Assert.assertNotNull(forecastUVIndex);
            System.out.println("Forecast UV Index by Coordinates");
            System.out.println(forecastUVIndex.toString());
        }catch(IOException e){
            Assert.fail();
        }
    }*/
}
