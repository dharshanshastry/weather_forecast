package com.org.dto;

import java.io.Serializable;

public class CoOrdinateDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double lattitude;
	
	private Double langitude;

	public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public Double getLangitude() {
		return langitude;
	}

	public void setLangitude(Double langitude) {
		this.langitude = langitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((langitude == null) ? 0 : langitude.hashCode());
		result = prime * result + ((lattitude == null) ? 0 : lattitude.hashCode());
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
		CoOrdinateDTO other = (CoOrdinateDTO) obj;
		if (langitude == null) {
			if (other.langitude != null)
				return false;
		} else if (!langitude.equals(other.langitude))
			return false;
		if (lattitude == null) {
			if (other.lattitude != null)
				return false;
		} else if (!lattitude.equals(other.lattitude))
			return false;
		return true;
	}

}
