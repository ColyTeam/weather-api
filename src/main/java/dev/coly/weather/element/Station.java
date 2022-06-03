package dev.coly.weather.element;

import org.jetbrains.annotations.Nullable;

public record Station(double longitude, double latitude, @Nullable String city) {

}
