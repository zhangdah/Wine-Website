package com.mie.model;

public class Region {
	private String regionName;
	private String country;
	
	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Region [regionName=" + regionName + ", country=" + country
				+ "]";
	}
}