package com.org.domain;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class WeatherForecastSummary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Set<WeatherForecast>> forecasts;

	public Map<String, Set<WeatherForecast>> getForecasts() {
		return forecasts;
	}

	public void setForecasts(Map<String, Set<WeatherForecast>> forecasts) {
		this.forecasts = forecasts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((forecasts == null) ? 0 : forecasts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherForecastSummary other = (WeatherForecastSummary) obj;
		if (forecasts == null) {
			if (other.forecasts != null)
				return false;
		} else if (!forecasts.equals(other.forecasts))
			return false;
		return true;
	}
	
	
	

}
