package com.org.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WindDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@JsonProperty("deg")
	private double degree;
	
	
	private double speed;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(degree);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(speed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		WindDTO other = (WindDTO) obj;
		if (Double.doubleToLongBits(degree) != Double.doubleToLongBits(other.degree))
			return false;
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
			return false;
		return true;
	}


	public double getDegree() {
		return degree;
	}


	public void setDegree(double degree) {
		this.degree = degree;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
