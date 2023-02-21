package com.zoneproduction.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("weather?appid=5a2e13432a773500ad203564adce8a05&units=metric")
    Call<OpenWeatherMap> getWeatherWithLocation(@Query("lat")double lat, @Query("lon") double lon);

    @GET("weather?appid=5a2e13432a773500ad203564adce8a05&units=metric")
    Call<OpenWeatherMap> getWeatherWithCityName(@Query("q")String name);

}
