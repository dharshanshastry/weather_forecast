package com.org.convertors;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.org.domain.WeatherForecast;
import com.org.domain.WeatherStatus;
import com.org.dto.ForecastDTO;
import com.org.dto.WeatherSummaryDTO;

@Component
public class WeatherForeCastDTOToWeatherForeCastConverterImpl implements  WeatherForeCastDTOToWeatherForeCastConverter {
	
	@Override
	public WeatherForecast convert(final ForecastDTO forecast){
		if (Objects.isNull(forecast)
				|| Objects.isNull(forecast.getWeatherSummary())
				|| (forecast.getWeatherSummary().size() == 0)) {
			return null;
		}

		final WeatherForecast weatherForecast = new WeatherForecast();
		final WeatherSummaryDTO weatherSummary = forecast.getWeatherSummary().get(0);
		final WeatherStatus status = WeatherStatus.getValue(weatherSummary.getMain());
		weatherForecast.setTime(forecast.getTime());
		weatherForecast.setWeatherStatus(status);
		weatherForecast.setDescription(weatherSummary.getDescription());
		return weatherForecast;
	}

}
