package dev.coly.weather.provider.brightsky.api;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Date;

public class BSCurrentWeather {

    @Getter
    private Weather weather;
    public class Weather {

        @Getter
        private int sourceId;
        @Getter
        private Date timestamp;
        @Getter
        @SerializedName("cloud_cover")
        private int cloudCover;
        @Getter
        private String condition;
        @Getter
        private double dewPoint;
        @Getter
        private String icon;
        @Getter
        @SerializedName("precipitation_60")
        private int precipitation;
        @Getter
        @SerializedName("pressure_msl")
        private double pressure;
        @Getter
        @SerializedName("relative_humidity")
        private int humidity;
        @Getter
        @SerializedName("sunshine_60")
        private int sunshine;
        @Getter
        private double temperature;
        @Getter
        private int visibilty;
        @Getter
        @SerializedName("wind_direction_60")
        private int windDirection;
        @Getter
        @SerializedName("wind_speed_60")
        public double windSpeed;
        @Getter
        @SerializedName("wind_gust_direction_60")
        public int windGustDirection;
        @Getter
        @SerializedName("wind_gust_speed_60")
        public double windGustSpeed;

    }

    @Getter
    public Source[] sources;
    public class Source {

        @Getter
        private int id;
        @Getter
        private String dwdStationId;
        @Getter
        private String wmoStationId;
        @Getter
        private String stationName;
        @Getter
        private ObservationType observationType;
        @Getter
        private Date firstRecord;
        @Getter
        private Date lastRecord;
        @Getter
        private double lat;
        @Getter
        private double lon;
        @Getter
        private double height;
        @Getter
        private double distance;

        public enum ObservationType {
            FORECAST, SYNOP, CURRENT, HISTORICAL
        }


    }

}
