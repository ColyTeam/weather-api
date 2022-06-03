package dev.coly.weather.provider.brightsky;

import com.google.gson.Gson;
import dev.coly.weather.element.CurrentWeather;
import dev.coly.weather.element.Station;
import dev.coly.weather.element.Weather;
import dev.coly.weather.provider.Provider;
import dev.coly.weather.provider.brightsky.api.BSCurrentWeather;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BrightSkyProvider extends Provider {

    private final Gson gson;

    private static final String HOST = "https://api.brightsky.dev/";

    public BrightSkyProvider() {
        gson = new Gson();
    }

    @Override
    public CurrentWeather getCurrentWeather(double longitude, double latitude) throws IOException {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        String content = Jsoup.connect(HOST + "/current_weather?lat=" + latitude + "&lon=" + longitude + "&date=" + date)
                .ignoreContentType(true).execute().body();
        BSCurrentWeather bsResponse = gson.fromJson(content, BSCurrentWeather.class);

        BSCurrentWeather.Source source = bsResponse.getSources()[0];

        Station station = new Station(source.getLat(), source.getLon(), source.getStationName());

        BSCurrentWeather.Weather bsWeather = bsResponse.getWeather();

        Weather.Wind wind = new Weather.Wind(bsWeather.getWindSpeed(), bsWeather.getWindDirection());

        Weather.Description description = Weather.Description.UNKNOWN;
        switch (bsWeather.getIcon()) {
            case "clear-day", "clear-night" -> description = Weather.Description.CLEAR;
            case "partly_cloud_day", "partly_cloud_night", "cloudy" -> description = Weather.Description.CLOUDS;
            case "rain" -> description = Weather.Description.RAIN;
            case "snow", "sleet", "hail" -> description = Weather.Description.SNOW;
            case "wind" -> description = Weather.Description.WIND;
            case "thunderstorm" -> description = Weather.Description.THUNDERSTORMS;
            case "fog" -> description = Weather.Description.FOG;
        }

        Weather weather = new Weather(description,
                bsWeather.getTemperature(), bsWeather.getTemperature(), wind,
                bsWeather.getCloudCover() / 100d, (int) bsWeather.getPressure(),
                bsWeather.getHumidity() / 100d);

        return new CurrentWeather(station, weather, bsWeather.getTimestamp());
    }

}
