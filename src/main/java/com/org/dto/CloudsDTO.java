package com.org.dto;

import java.io.Serializable;

public class CloudsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long all;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (all ^ (all >>> 32));
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
		CloudsDTO other = (CloudsDTO) obj;
		if (all != other.all)
			return false;
		return true;
	}

	public long getAll() {
		return all;
	}

	public void setAll(long all) {
		this.all = all;
	}
	
	

}
