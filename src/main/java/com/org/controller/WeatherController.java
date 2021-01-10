package com.org.controller;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.constants.LocaleConstants;
import com.org.domain.WeatherForecast;
import com.org.domain.WeatherForecastSummary;
import com.org.domain.WeatherStatus;
import com.org.service.WeatherService;

@RestController
@RequestMapping(value ="/forecast", produces = "application/json")
public class WeatherController extends AbstractController {

	@Autowired
	private WeatherService weatherService ;
	
	@Autowired
    private MessageSource messageSource;
	
	@GetMapping
	public WeatherForecastSummary forecast(@NotBlank @RequestParam(required =  true) final String cityName, final Locale locale) {
		final Map<String, Set<WeatherForecast>> forecastsPerDay =  weatherService.fetchAndPredictWeather(cityName);
		final WeatherForecastSummary weatherForecastSummary = new WeatherForecastSummary();
	
		massageSuggetionsBasedonLocale(forecastsPerDay, locale);

		weatherForecastSummary.setForecasts(forecastsPerDay);
		return weatherForecastSummary;
	}

	private void massageSuggetionsBasedonLocale(final Map<String, Set<WeatherForecast>> forecastsPerDay, final Locale locale) {
		forecastsPerDay.values().stream().flatMap(forecasts -> forecasts.stream()).forEach(foreCast -> {
			if (foreCast.getWeatherStatus().equals( WeatherStatus.EXTREME)) {
				foreCast.setUserSuggestion(messageSource.getMessage(LocaleConstants.USE_SUNSCREEN_LOTION, null,  Locale.getDefault()));
			} else if (foreCast.getWeatherStatus().equals( WeatherStatus.RAIN)) {
				foreCast.setUserSuggestion(messageSource.getMessage(LocaleConstants.CARRY_UMBRELLA, null,  Locale.getDefault()));
			}
		});
	}
}
