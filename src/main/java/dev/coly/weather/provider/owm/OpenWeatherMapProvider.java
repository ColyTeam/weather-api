package dev.coly.weather.provider.owm;

import com.google.gson.Gson;
import dev.coly.weather.element.CurrentWeather;
import dev.coly.weather.element.Station;
import dev.coly.weather.element.Weather;
import dev.coly.weather.provider.Provider;
import dev.coly.weather.provider.owm.api.OWMCurrentWeather;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Date;

public class OpenWeatherMapProvider extends Provider {

    private final Gson gson;

    private static final String HOST = "https://api.openweathermap.org/data/2.5";

    private final String apiKey;

    public OpenWeatherMapProvider(String apiKey) {
        this.apiKey = apiKey;
        this.gson = new Gson();
    }


    @Override
    public CurrentWeather getCurrentWeather(double longitude, double latitude) throws IOException {
        String content = Jsoup.connect(HOST + "/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + this.apiKey)
                .ignoreContentType(true).execute().body();
        OWMCurrentWeather owmResponse = gson.fromJson(content, OWMCurrentWeather.class);

        Station station = new Station(owmResponse.getCoordinates().getLongitude(),
                owmResponse.getCoordinates().getLatitude(), owmResponse.getCityName());

        Weather.Wind wind = new Weather.Wind(owmResponse.getWind().getSpeed(), owmResponse.getWind().getDegree());

        if (owmResponse.getWeatherDescription().length == 0) {
            throw new RuntimeException("Could not load description of weather from location");
        }

        Weather weather = new Weather(Weather.Description.valueOf(
                owmResponse.getWeatherDescription()[0].getType().toUpperCase()),
                owmResponse.getWeather().getTemperature(), owmResponse.getWeather().getFeelsLike(), wind,
                owmResponse.getClouds().getCloudiness() / 100, owmResponse.getWeather().getPressure(),
                owmResponse.getWeather().getHumidity() / 100d);

        return new CurrentWeather(station, weather, new Date(owmResponse.getDateTime() * 1000));
    }
}
