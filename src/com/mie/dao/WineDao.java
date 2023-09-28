package com.mie.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import com.mie.model.Wine;
import com.mie.util.DbUtil;

/**
 * @author zhan6665
 *
 */
public class WineDao {
	/**
	 * This class handles all wine-related methods. 
	 * 
	 */
	
	private Connection connection;
	
	public WineDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public Wine getWineNameByID (String WineID){
		/**
		 * This method returns the wine of the wineID given
		 */
		Wine wine = new Wine();
		try{
			PreparedStatement preparedStatement;
			double Wine_ID = Double.parseDouble(WineID);
			preparedStatement = connection.prepareStatement("Select * from "
					+ "[Wine Master] where Wine_ID=?");
			preparedStatement.setDouble(1, Wine_ID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
				wine.setWineid((int)Wine_ID);
				wine.setRegion(rs.getString("Region"));
				wine.setWineName(rs.getString("Wine_Name"));
				wine.setWineDescription(rs.getString("Wine_Description"));
				wine.setWinery(rs.getString("Winery"));
				wine.setYear(rs.getInt("Year"));
				wine.setWineRating(rs.getDouble("Wine_Rating"));
				wine.setRatingCount(rs.getInt("Wine_Rating_Count"));
				wine.setWinePicURL(rs.getString("Wine_Image"));
				wine.setPrice(rs.getDouble("Price"));
				wine.setWineType(rs.getString("Wine_Type_Name"));
				wine.setAlcoholLevel(rs.getDouble("Alcohol_level"));
				wine.setBottleSize(rs.getInt("Bottle_Size"));
				wine.setSugarContent(rs.getString("Sugar_Content"));
				wine.setSweetness(rs.getString("Sweetness_Descriptor"));
				wine.setOccasion(rs.getString("Occasion"));
				wine.setTaste(rs.getString("Taste"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (NumberFormatException e){
			e.printStackTrace();
		}
		return wine;	
	}
	
	public ArrayList<Wine> getWineByKeyword (String keywords){
		/**
		 * This method retrieves a list of wine that matches the keyword
		 * entered by the user.
		 */
		
		ArrayList<Wine> winelist = new ArrayList<Wine>();
		
		ArrayList<String> keyword_list = new ArrayList<String>();
		
		StringTokenizer tokenizer = new StringTokenizer(keywords, ","); 
		
		while (tokenizer.hasMoreTokens()){
			keyword_list.add(tokenizer.nextToken());
		}
		
		System.out.println(keyword_list);
		
		for (String keyword : keyword_list){
			try{
				PreparedStatement preparedStatement;

				preparedStatement = connection
				.prepareStatement("Select * from [Wine Master] where Wine_Name Like ? "
						+ "OR Wine_Description Like ? OR Wine_Rating Like ? OR "
						+ "Winery Like ? OR Year Like ? OR Region Like ? OR "
						+ "Wine_Type_Name Like ? OR Price Like ? OR "
						+ "Alcohol_level Like ? OR Bottle_Size Like ? OR "
						+ "Sugar_Content Like ? OR Sweetness_Descriptor Like ? OR "
						+ "Occasion Like ? OR Taste Like ?");
				
				preparedStatement.setString(1, "%" + keyword + "%");
				preparedStatement.setString(2, "%" + keyword + "%");
				preparedStatement.setString(3, "%" + keyword + "%");	
				preparedStatement.setString(4, "%" + keyword + "%");
				preparedStatement.setString(5, "%" + keyword + "%");
				preparedStatement.setString(6, "%" + keyword + "%");			
				preparedStatement.setString(7, "%" + keyword + "%");
				preparedStatement.setString(8, "%" + keyword + "%");
				preparedStatement.setString(9, "%" + keyword + "%");
				preparedStatement.setString(10, "%" + keyword + "%");	
				preparedStatement.setString(11, "%" + keyword + "%");
				preparedStatement.setString(12, "%" + keyword + "%");
				preparedStatement.setString(13, "%" + keyword + "%");			
				preparedStatement.setString(14, "%" + keyword + "%");
				
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()){
					Wine wine = new Wine();
					wine.setWineid(rs.getInt("Wine_ID"));
					wine.setRegion(rs.getString("Region"));
					wine.setWineName(rs.getString("Wine_Name"));
					wine.setWineDescription(rs.getString("Wine_Description"));
					wine.setWinery(rs.getString("Winery"));
					wine.setYear(rs.getInt("Year"));
					wine.setWineRating(rs.getDouble("Wine_Rating"));
					wine.setRatingCount(rs.getInt("Wine_Rating_Count"));
					wine.setWinePicURL(rs.getString("Wine_Image"));
					wine.setPrice(rs.getDouble("Price"));
					wine.setWineType(rs.getString("Wine_Type_Name"));
					wine.setAlcoholLevel(rs.getDouble("Alcohol_level"));
					wine.setBottleSize(rs.getInt("Bottle_Size"));
					wine.setSugarContent(rs.getString("Sugar_Content"));
					wine.setSweetness(rs.getString("Sweetness_Descriptor"));
					wine.setOccasion(rs.getString("Occasion"));
					wine.setTaste(rs.getString("Taste"));
					
					winelist.add(wine);
				}
				
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return winelist;
	}
	public ArrayList<Wine> getWineByFilter (String wineType, String occasion, String taste, String sweet, String price){
		/**
		 * This method handles the quiz input and the filter checkbox input
		 * and return the filtered wine list
		 */
		  
		  ArrayList<Wine> winelist = new ArrayList<Wine>();
		  if (price.equals("$")){
		    price = "< 20";
		   }else if(price.equals("$$")){
		    price = "BETWEEN 20 AND 50";
		   }else if (price.equals("$$$")){
		    price = "> 50";
		   }else{
			   price = " > 0";
		   }
		  if (wineType.equals("''")){
		   wineType = "'Red','White','Ice','Champagne'";
		  }
		  if (occasion.equals("''")){
		   occasion = "'Party','Brunch','Cooking','Dinner','Dessert'";
		  }
		  if (taste.equals("''")){
		   taste = "'Fruity', 'Citrus', 'Floral'";
		  }
		  if (sweet.equals("''")){
		   sweet = "IN ('D','XD','M','S')";
		  }else if(sweet.length() < 5){
			  sweet = " = " + sweet;
		  }else{
			  sweet = "IN (" + sweet + ")";
		  }
		  
		  String qStr = "Select * from [Wine Master] where Wine_Type_Name IN (" + wineType + ") AND Occasion IN (" +
		    occasion + ") AND Taste IN (" + taste + ") AND Sweetness_Descriptor " + 
		    sweet + " AND Price " + price ;
		   try{
		    
		    java.sql.Statement statement = connection.createStatement();
		    
		    ResultSet rs = statement.executeQuery(qStr);
		    while (rs.next()){
		     Wine wine = new Wine();
		     wine.setWineid(rs.getInt("Wine_ID"));
		     wine.setRegion(rs.getString("Region"));
		     wine.setWineName(rs.getString("Wine_Name"));
		     wine.setWineDescription(rs.getString("Wine_Description"));
		     wine.setWinery(rs.getString("Winery"));
		     wine.setYear(rs.getInt("Year"));
		     wine.setWineRating(rs.getDouble("Wine_Rating"));
		     wine.setRatingCount(rs.getInt("Wine_Rating_Count"));
		     wine.setWinePicURL(rs.getString("Wine_Image"));
		     wine.setPrice(rs.getDouble("Price"));
		     wine.setWineType(rs.getString("Wine_Type_Name"));
		     wine.setAlcoholLevel(rs.getDouble("Alcohol_level"));
		     wine.setBottleSize(rs.getInt("Bottle_Size"));
		     wine.setSugarContent(rs.getString("Sugar_Content"));
		     wine.setSweetness(rs.getString("Sweetness_Descriptor"));
		     wine.setOccasion(rs.getString("Occasion"));
					
					winelist.add(wine);
				}
				
			}catch (SQLException e){
				e.printStackTrace();
			}
		
		
		return winelist;
	}
	
	public ArrayList <Wine> getAllWines(){
		/**
		 * This method returns all wine in database
		 */
		ArrayList <Wine> wineList = new ArrayList <Wine>();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from [Wine Master]");
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()){
				Wine wine = new Wine();
				wine.setWineid(rs.getInt("Wine_ID"));
				wine.setRegion(rs.getString("Region"));
				wine.setWineName(rs.getString("Wine_Name"));
				wine.setWineDescription(rs.getString("Wine_Description"));
				wine.setWinery(rs.getString("Winery"));
				wine.setYear(rs.getInt("Year"));
				wine.setWineRating(rs.getDouble("Wine_Rating"));
				wine.setRatingCount(rs.getInt("Wine_Rating_Count"));
				wine.setWinePicURL(rs.getString("Wine_Image"));
				wine.setPrice(rs.getDouble("Price"));
				wine.setWineType(rs.getString("Wine_Type_Name"));
				wine.setAlcoholLevel(rs.getDouble("Alcohol_level"));
				wine.setBottleSize(rs.getInt("Bottle_Size"));
				wine.setSugarContent(rs.getString("Sugar_Content"));
				wine.setSweetness(rs.getString("Sweetness_Descriptor"));
				wine.setOccasion(rs.getString("Occasion"));
				wine.setTaste(rs.getString("Taste"));
				
				wineList.add(wine);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return wineList;	
	}
}
