package com.org.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WeatherForecast implements Serializable, Comparable<WeatherForecast> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private WeatherStatus weatherStatus;
	
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date time;
	
	private String userSuggestion;

	public WeatherStatus getWeatherStatus() {
		return weatherStatus;
	}

	public void setWeatherStatus(WeatherStatus weatherStatus) {
		this.weatherStatus = weatherStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getUserSuggestion() {
		return userSuggestion;
	}

	public void setUserSuggestion(String userSuggestion) {
		this.userSuggestion = userSuggestion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((userSuggestion == null) ? 0 : userSuggestion.hashCode());
		result = prime * result + ((weatherStatus == null) ? 0 : weatherStatus.hashCode());
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
		WeatherForecast other = (WeatherForecast) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (userSuggestion == null) {
			if (other.userSuggestion != null)
				return false;
		} else if (!userSuggestion.equals(other.userSuggestion))
			return false;
		if (weatherStatus != other.weatherStatus)
			return false;
		return true;
	}

	@Override
	public int compareTo(WeatherForecast o) {
		return this.getTime().compareTo(o.getTime());
	}
	
	
}
