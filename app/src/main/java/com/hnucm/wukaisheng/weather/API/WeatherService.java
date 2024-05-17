package com.hnucm.wukaisheng.weather.API;

import com.hnucm.wukaisheng.weather.Day15;
import com.hnucm.wukaisheng.weather.Hour24;
import com.hnucm.wukaisheng.weather.SevenDaysInTheFuture;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("area-to-weather-date")
    Call<SevenDaysInTheFuture> getSevenDaysInTheFutureData(@Header("Authorization") String token,@Query("area")String area);
    @GET("day15")
    Call<Day15> getDay15Data(@Header("Authorization") String token,@Query("area")String area);
    @GET("hour24")
    Call<Hour24> getHour24Data(@Header("Authorization") String token, @Query("area")String area);

}