package dev.coly.weather;

import dev.coly.weather.element.CurrentWeather;
import dev.coly.weather.provider.Provider;
import dev.coly.weather.provider.brightsky.BrightSkyProvider;
import dev.coly.weather.provider.owm.OpenWeatherMapProvider;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WeatherAPI {

    private List<Provider> providers = new LinkedList<>();

    public WeatherAPI addOpenWeatherMap(String apiKey) {
        if (providers.stream().anyMatch(provider -> provider.getClass().equals(OpenWeatherMapProvider.class))) {
            throw new IllegalStateException("Provider already added");
        }

        providers.add(new OpenWeatherMapProvider(apiKey));

        return this;
    }

    public WeatherAPI addBrightSky() {
        if (providers.stream().anyMatch(provider -> provider.getClass().equals(OpenWeatherMapProvider.class))) {
            throw new IllegalStateException("Provider already added");
        }

        providers.add(new BrightSkyProvider());

        return this;
    }

    public CurrentWeather getCurrentWeather(double longitude, double latitude) throws IOException {
        return providers.get(0).getCurrentWeather(longitude, latitude);
    }

}
