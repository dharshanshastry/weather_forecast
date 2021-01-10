package com.org.convertors;

import com.org.domain.WeatherForecast;
import com.org.dto.ForecastDTO;

public interface WeatherForeCastDTOToWeatherForeCastConverter {

	WeatherForecast convert(ForecastDTO forecast);

}
