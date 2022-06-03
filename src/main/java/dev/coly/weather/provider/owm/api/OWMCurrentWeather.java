package dev.coly.weather.provider.owm.api;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class OWMCurrentWeather {

    @Getter
    @SerializedName("coord")
    private Coordinates coordinates;
    public static class Coordinates {

        @Getter
        @SerializedName("lon")
        private double longitude;
        @Getter
        @SerializedName("lat")
        private double latitude;

    }

    @Getter
    @SerializedName("weather")
    private WeatherDescription[] weatherDescription;
    public static class WeatherDescription {

        @Getter
        private int id;
        @Getter
        @SerializedName("main")
        private String type;
        @Getter
        @SerializedName("description")
        private String description;
        @Getter
        private String icon;

    }

    @Getter
    public String base;

    @Getter
    @SerializedName("main")
    private Weather weather;
    public class Weather {

        @Getter
        @SerializedName("temp")
        private double temperature;
        @Getter
        @SerializedName("feels_like")
        private double feelsLike;
        @Getter
        @SerializedName("temp_min")
        private double temperatureMin;
        @Getter
        @SerializedName("temp_max")
        private double temperatureMax;
        @Getter
        private int pressure;
        @Getter
        private int humidity;

    }

    @Getter
    private int visibility;

    @Getter
    private Wind wind;
    public class Wind {

        @Getter
        private double speed;
        @Getter
        @SerializedName("deg")
        private int degree;

    }

    @Getter
    private Clouds clouds;
    public class Clouds {

        @Getter
        @SerializedName("all")
        private double cloudiness;

    }

    @Getter
    @SerializedName("dt")
    private long dateTime;
    @Getter
    @SerializedName("id")
    private long cityId;
    @Getter
    @SerializedName("name")
    private String cityName;

}
