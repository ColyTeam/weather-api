package dev.coly.weather.element;

public record Weather(Description description, double temperature, double temperatureFeelsLike, Wind wind,
                      double cloudiness, int pressure, double humidity) {

    public enum Description {
        RAIN, SNOW, CLEAR, CLOUDS, THUNDERSTORMS, WIND, FOG, UNKNOWN
    }

    public record Wind(double speed, int degree) {

    }

}
