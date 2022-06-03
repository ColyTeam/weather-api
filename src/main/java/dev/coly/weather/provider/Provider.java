package dev.coly.weather.provider;

import dev.coly.weather.element.CurrentWeather;

import java.io.IOException;

public abstract class Provider {

    public abstract CurrentWeather getCurrentWeather(double longitude, double latitude) throws IOException;

}
