package com.org.service;

import java.util.Map;
import java.util.Set;

import com.org.domain.WeatherForecast;

public interface WeatherService {

	Map<String, Set<WeatherForecast>> fetchAndPredictWeather(String cityName);
	
}
