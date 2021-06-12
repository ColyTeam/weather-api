package dev.coly.weather;

import org.json.JSONObject;

/**
 * Created by Gregyyy on 02.12.2017.
 */
public class WeatherState {

    private String weather;
    private String weatherDescription;
    private int weatherId;
    private String weatherIcon;
    private Double temperature;
    private Double temperatureMin;
    private Double temperatureMax;
    private int pressure;
    private int humidity;
    private Double windSpeed;
    private int windDegree;
    private int cloudiness;
    private double seaLevel;
    private double groundLevel;

    public WeatherState(){
    }

    public WeatherState(String weather, String weatherDescription, int weatherId, String weatherIcon, Double temperature,
                        Double temperatureMin, Double temperatureMax, int pressure, int humidity, Double windSpeed,
                        int windDegree, int cloudiness, double seaLevel, double groundLevel) {
        this.weather = weather;
        this.weatherDescription = weatherDescription;
        this.weatherId = weatherId;
        this.weatherIcon = weatherIcon;
        this.temperature = temperature;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
        this.cloudiness = cloudiness;
        this.seaLevel = seaLevel;
        this.groundLevel = groundLevel;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public Double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(int windDegree) {
        this.windDegree = windDegree;
    }

    public int getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(int cloudiness) {
        this.cloudiness = cloudiness;
    }

    public double getSeaLevel(){
        return seaLevel;
    }

    public void setSeaLevel(double seaLevel){
        this.seaLevel = seaLevel;
    }

    public double getGroundLevel(){
        return groundLevel;
    }

    public void setGroundLevel(double groundLevel){
        this.groundLevel = groundLevel;
    }

    @Override
    public String toString(){
        return "WeatherState{" +
                "weather='" + weather + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                ", weatherId=" + weatherId +
                ", weatherIcon='" + weatherIcon + '\'' +
                ", temperature=" + temperature +
                ", temperatureMin=" + temperatureMin +
                ", temperatureMax=" + temperatureMax +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windDegree=" + windDegree +
                ", cloudiness=" + cloudiness +
                ", seaLevel=" + seaLevel +
                ", groundLevel=" + groundLevel +
                '}';
    }

    public JSONObject toJSON() {
        return new JSONObject().append("weather", weather).append("weatherDescription", weatherDescription)
                .append("weatherId", weatherId).append("weatherIcon", weatherIcon).append("temperature", temperature)
                .append("temperatureMin", temperatureMin).append("temperatureMax", temperatureMax)
                .append("pressure", pressure).append("humidity", humidity).append("windSpeed", windSpeed)
                .append("windDegree", windDegree).append("cloudiness", cloudiness).append("seaLevel", seaLevel)
                .append("groundLevel", groundLevel);
    }
}
