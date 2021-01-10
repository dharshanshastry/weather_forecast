package com.org.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("dt")
	private long dayTime;
	
	private SysDTO sys;
	
	private CloudsDTO clouds;
	
	private WindDTO wind;
	
	private RainDTO rain;
	
	private SnowDTO snow;
	
	@JsonProperty("main")
	private WeatherDTO weather;
	
	@JsonProperty("weather")
	private List<WeatherSummaryDTO> weatherSummary;
	
	@JsonProperty("dt_txt")
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date time;

	public long getDayTime() {
		return dayTime;
	}

	public void setDayTime(long dayTime) {
		this.dayTime = dayTime;
	}

	public SysDTO getSys() {
		return sys;
	}

	public void setSys(SysDTO sys) {
		this.sys = sys;
	}

	public CloudsDTO getClouds() {
		return clouds;
	}

	public void setClouds(CloudsDTO clouds) {
		this.clouds = clouds;
	}

	public WindDTO getWind() {
		return wind;
	}

	public void setWind(WindDTO wind) {
		this.wind = wind;
	}

	public WeatherDTO getWeather() {
		return weather;
	}

	public void setWeather(WeatherDTO weather) {
		this.weather = weather;
	}

	public List<WeatherSummaryDTO> getWeatherSummary() {
		return weatherSummary;
	}

	public void setWeatherSummary(List<WeatherSummaryDTO> weatherSummary) {
		this.weatherSummary = weatherSummary;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clouds == null) ? 0 : clouds.hashCode());
		result = prime * result + (int) (dayTime ^ (dayTime >>> 32));
		result = prime * result + ((sys == null) ? 0 : sys.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((weather == null) ? 0 : weather.hashCode());
		result = prime * result + ((weatherSummary == null) ? 0 : weatherSummary.hashCode());
		result = prime * result + ((wind == null) ? 0 : wind.hashCode());
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
		ForecastDTO other = (ForecastDTO) obj;
		if (clouds == null) {
			if (other.clouds != null)
				return false;
		} else if (!clouds.equals(other.clouds))
			return false;
		if (dayTime != other.dayTime)
			return false;
		if (sys == null) {
			if (other.sys != null)
				return false;
		} else if (!sys.equals(other.sys))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (weather == null) {
			if (other.weather != null)
				return false;
		} else if (!weather.equals(other.weather))
			return false;
		if (weatherSummary == null) {
			if (other.weatherSummary != null)
				return false;
		} else if (!weatherSummary.equals(other.weatherSummary))
			return false;
		if (wind == null) {
			if (other.wind != null)
				return false;
		} else if (!wind.equals(other.wind))
			return false;
		return true;
	}

	public RainDTO getRain() {
		return rain;
	}

	public void setRain(RainDTO rain) {
		this.rain = rain;
	}

	public SnowDTO getSnow() {
		return snow;
	}

	public void setSnow(SnowDTO snow) {
		this.snow = snow;
	}
	
	
	
	

}
