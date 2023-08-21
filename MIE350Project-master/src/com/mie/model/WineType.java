package com.mie.model;

public class WineType {
	
	private String wineType;
	private String wineTypeDescription;
	
	public String getWineType() {
		return wineType;
	}
	public void setWineType(String wineType) {
		this.wineType = wineType;
	}
	public String getWineTypeDescription() {
		return wineTypeDescription;
	}
	public void setWineTypeDescription(String wineTypeDescription) {
		this.wineTypeDescription = wineTypeDescription;
	}
	
	@Override
	public String toString() {
		return "WineType [wineType=" + wineType + ", wineTypeDescription="
				+ wineTypeDescription + "]";
	}

}
