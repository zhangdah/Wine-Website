package com.mie.model;

public class Wine {
	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the Wine object.
	 */
	
	private int wineid;
	private String wineName;
	private String wineDescription;
	private String winery;
	private int year;
	private String region;
	private double wineRating;
	private int ratingCount;
	private String winePicURL;
	private double price;
	private String wineType;
	private double alcoholLevel;
	private int bottleSize;
	private String sugarContent;
	private String sweetness;
	private String occasion;
	private String taste;
	private Integer faveID;
	
	public String getWineDescription() {
		return wineDescription;
	}

	public void setWineDescription(String wineDescription) {
		this.wineDescription = wineDescription;
	}

	public String getWinery() {
		return winery;
	}

	public void setWinery(String winery) {
		this.winery = winery;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getWineRating() {
		return wineRating;
	}

	public void setWineRating(double wineRating) {
		this.wineRating = wineRating;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}

	public String getWinePicURL() {
		return winePicURL;
	}

	public void setWinePicURL(String winePicURL) {
		this.winePicURL = winePicURL;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getWineType() {
		return wineType;
	}

	public void setWineType(String wineType) {
		this.wineType = wineType;
	}

	public double getAlcoholLevel() {
		return alcoholLevel;
	}

	public void setAlcoholLevel(double alcoholLevel) {
		this.alcoholLevel = alcoholLevel;
	}

	public int getBottleSize() {
		return bottleSize;
	}

	public void setBottleSize(int bottleSize) {
		this.bottleSize = bottleSize;
	}

	public String getSugarContent() {
		return sugarContent;
	}

	public void setSugarContent(String sugarContent) {
		this.sugarContent = sugarContent;
	}

	public String getSweetness() {
		return sweetness;
	}

	public void setSweetness(String sweetness) {
		this.sweetness = sweetness;
	}

	public int getWineid() {
		return wineid;
	}

	public void setWineid(int wineid) {
		this.wineid = wineid;
	}

	public String getWineName() {
		return wineName;
	}

	public void setWineName(String wineName) {
		this.wineName = wineName;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occation) {
		this.occasion = occation;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	public void setFavId(Integer id){
		this.faveID = id;
	}
	public Integer getFavId(){
		return faveID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Wine [wineid=" + wineid + ", wineName=" + wineName
				+ ", wineDescription=" + wineDescription + ", winery=" + winery
				+ ", year=" + year + ", region=" + region + ", wineRating="
				+ wineRating + ", ratingCount=" + ratingCount + ", winePicURL="
				+ winePicURL + ", price=" + price + ", wineType=" + wineType
				+ ", alcoholLevel=" + alcoholLevel + ", bottleSize="
				+ bottleSize + ", sugarContent=" + sugarContent
				+ ", sweetness=" + sweetness + ", occasion=" + occasion
				+ ", taste=" + taste +", faveID:" +faveID+ "]";
	}
}
