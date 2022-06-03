package dev.coly.weather.test;

import dev.coly.weather.WeatherAPI;
import dev.coly.weather.element.CurrentWeather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

public class TestBrightSky {

    @Test
    public void testGetCurrentWeather() {
        WeatherAPI api = new WeatherAPI().addBrightSky();

        try {
            CurrentWeather weather = api.getCurrentWeather(8.24, 49);

            Assertions.assertNotNull(weather.weather());
            Assertions.assertNotNull(weather.station());
            Assertions.assertNotNull(weather.timestamp());

            Assertions.assertNotNull(weather.weather().description());
            Assertions.assertTrue(weather.weather().temperature() > -150 &&
                    weather.weather().temperature() < 400);
            Assertions.assertTrue(weather.weather().temperatureFeelsLike() > -200 &&
                    weather.weather().temperatureFeelsLike() < 400);
            Assertions.assertNotNull(weather.weather().wind());
            Assertions.assertTrue(weather.weather().wind().speed() >= 0 &&
                    weather.weather().wind().speed() < 300);
            Assertions.assertTrue(weather.weather().wind().degree() >= 0 &&
                    weather.weather().wind().degree() < 365);
            Assertions.assertTrue(weather.weather().cloudiness() >= 0 && weather.weather().cloudiness() <= 1);
            Assertions.assertTrue(weather.weather().pressure() > 0);
            Assertions.assertTrue(weather.weather().humidity() >= 0 && weather.weather().humidity() <= 1);

            Assertions.assertTrue(weather.timestamp().before(new Date()));
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

}
