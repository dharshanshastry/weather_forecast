package com.org.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherForeCastDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cod;
	
	private String message;
	
	private int count;
	
	@JsonProperty("list")
	private List<ForecastDTO> forecasts;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<ForecastDTO> getForecasts() {
		return forecasts;
	}

	public void setForecasts(List<ForecastDTO> forecasts) {
		this.forecasts = forecasts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		result = prime * result + count;
		result = prime * result + ((forecasts == null) ? 0 : forecasts.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		WeatherForeCastDTO other = (WeatherForeCastDTO) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		if (count != other.count)
			return false;
		if (forecasts == null) {
			if (other.forecasts != null)
				return false;
		} else if (!forecasts.equals(other.forecasts))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
	
	
	

}
