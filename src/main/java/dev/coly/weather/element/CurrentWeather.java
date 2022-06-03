package dev.coly.weather.element;

import java.util.Date;

public record CurrentWeather(Station station, Weather weather, Date timestamp) {

}
