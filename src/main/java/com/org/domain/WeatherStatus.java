package com.org.domain;

public enum WeatherStatus {
	
	SNOW("snow"),
	RAIN("rain"),
	EXTREME("extreme"),
	CLEAR("clear"),
	CLOUDS("clouds");
	
	
	WeatherStatus(String status) {
		this.status = status;
	}

	private String status;
	
	public static WeatherStatus getValue(String status) {
		if (status.toLowerCase().equals("clear")) {
			return CLEAR;
		}
		if (status.toLowerCase().equals("rain")) {
			return RAIN;
		}
		
		if (status.toLowerCase().equals("snow")) {
			return SNOW;
		}
		
		if (status.toLowerCase().equals("extreme")) {
			return EXTREME;
		}
		if (status.toLowerCase().equals("clouds")) {
			return CLOUDS;
		}
		return null;
	}
}
