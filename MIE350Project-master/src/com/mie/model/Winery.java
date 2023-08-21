package com.mie.model;

public class Winery {
	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the Winery object.
	 */
	
	public String wineryName;
	public String Region;
	
	public String getWineryName() {
		return wineryName;
	}
	public void setWineryName(String wineryName) {
		this.wineryName = wineryName;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	
	@Override
	public String toString() {
		return "Winery [wineryName=" + wineryName + ", Region=" + Region + "]";
	}

}
