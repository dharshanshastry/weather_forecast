package com.org.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.org.constants.CacheConstants;
import com.org.convertors.WeatherForeCastDTOToWeatherForeCastConverter;
import com.org.domain.WeatherForecast;
import com.org.dto.ForecastDTO;
import com.org.dto.WeatherForeCastDTO;
import com.org.restclient.OpenWeatherRestClient;
import com.org.utils.DateUtils;

@Service
public class WeatherServiceImpl implements WeatherService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherRestClient.class);
	
	@Autowired
	private OpenWeatherRestClient restClient;
	
	@Autowired
	private WeatherForeCastDTOToWeatherForeCastConverter converter;
	
	@Override
	//TODO: Implement Caching to avoid too many calls.
	@Cacheable(value = CacheConstants.WEATHER_CACHE)
	public Map<String, Set<WeatherForecast>> fetchAndPredictWeather(final String cityName) {
		LOGGER.debug("Fetching weather data for city {}", cityName);
		final Map<String, Set<WeatherForecast>> forecastPerDay = new LinkedHashMap<>();

		final WeatherForeCastDTO weatherForeCastDTO = restClient.getWeather(cityName);
		final List<ForecastDTO> forecasts = weatherForeCastDTO.getForecasts();

		forecasts.forEach(forecast -> {
			WeatherForecast weatherForecast = converter.convert(forecast);
			String dayKey = DateUtils.formatDate(forecast.getTime());
			forecastPerDay.putIfAbsent(dayKey, new TreeSet<>());
			if (Objects.nonNull(weatherForecast)) {
				forecastPerDay.get(dayKey).add(weatherForecast);
			}
		});

		return forecastPerDay;
	}

}
