package com.org.restclient;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.org.dto.WeatherForeCastDTO;
import com.org.exceptions.WeatherServiceException;

@Component
public class OpenWeatherRestClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherRestClient.class);
	
	private static final String WEATHER_API_QUERY_PARAM_FORMAT = "?q={q}s&appid={apiKey}";

	@Autowired
	RestTemplate weatherRestTemplate;

	@Value( "${openweather.api.url}" )
	private String apiUrl;

	@Value( "${openweather.api.key}" )
	private String apiKey;

	//TODO: Implement circuit breaker to handle service down.
	public WeatherForeCastDTO getWeather(final String cityName) {
		try {
			Map<String, String> vars = new HashMap<>(2);
			vars.put("q", cityName);
			vars.put("apiKey", apiKey);
			ResponseEntity<WeatherForeCastDTO> response = weatherRestTemplate.getForEntity(apiUrl.concat(WEATHER_API_QUERY_PARAM_FORMAT)
					, WeatherForeCastDTO.class, vars);
			return response.getBody();
		} catch (Exception  e) {
			LOGGER.error("Error occured while making api call", e);
			throw new WeatherServiceException(String.format("Error while trying to fetch weather data for city - %s" ,  cityName), "101");
		}
	}
}
