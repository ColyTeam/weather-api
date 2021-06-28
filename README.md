# WeatherAPI
An API wrapper for the [openweathermap.org](https://openweathermap.org) API

## Installation
Download the jar file from the [release page](https://github.com/ColyTeam/weather-api/releases/latest).

### Maven
```xml
<repository>
    <id>coly</id>
    <url>https://m2.coly.dev/releases</url>
</repository>

<dependency>
    <groupId>dev.coly</groupId>
    <artifactId>weather-api</artifactId>
    <version>VERSION</version>
</dependency>
````

## Usage
This project can only be used as a libary.

Create WeatherClient object with api key. This key can be obtained at [home.openweathermap.org/api_keys](https://home.openweathermap.org/api_keys) using an account.
```JAVA
WeatherClient client = new WeatherClient(API_KEY);
```

### Examples
```JAVA
CurrentWeather weather = client.getCurrentWeatherByCityName("Berlin", UnitType.Metric, "EN");
System.out.println("It is currently " + weather.getWeatherState().getTemperature() + "°C in " + weather.getStation().getName());
```

```JAVA
CurrentWeather weather = client.getCurrentWeatherByCoordinates(52.5, 13.4, UnitType.Metric, "EN");
System.out.println("It is currently " + weather.getWeatherState().getTemperature() + "°C in " + weather.getStation().getName());
```

```JAVA
ForecastWeather weather = client.getForecastWeatherByCityName("Berlin", UnitType.Metric, "EN");
System.out.println("There are " + weather.getWeatherStates().size() + " forecasts for " + weather.getStation().getName());
```
