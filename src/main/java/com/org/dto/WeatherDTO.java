package com.org.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double temp;
	
	@JsonProperty("temp_min")
	private double minTemp;
	
	@JsonProperty("temp_max")
	private double maxTemp;
	
	private double pressure;
	
	@JsonProperty("sea_level")
	private double seaLevel;
	
@JsonProperty("grnd_level")
	private double groundLevel;
	
	
	private long humidity;
	
	@JsonProperty("temp_kf")
	private double tempKf;
	
	@JsonProperty("dt_txt")
	private Date time;

}
