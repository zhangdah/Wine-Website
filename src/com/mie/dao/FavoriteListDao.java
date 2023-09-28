package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mie.model.Wine;
import com.mie.model.FavoriteList;
import com.mie.util.DbUtil;


public class FavoriteListDao {
	/**
	 * This class deals with favourite list in the database
	 */
	private Connection connection;
	
	public FavoriteListDao(){
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public String addWine (String WineID, Integer FavId){
		/**
		 * This method writes the information of the wine into the database
		 */
	
		String note = "";
		try{
			PreparedStatement preparedStatement;
			double Wine_ID = Double.parseDouble(WineID);
			preparedStatement = connection.prepareStatement("INSERT INTO FavouriteList VALUES (" + Wine_ID + ","+FavId+")");
			note = "frick";
			preparedStatement.executeUpdate();
		
		
		}catch (SQLException e){
			e.printStackTrace();
			note = "no";
	
		}catch (NumberFormatException e){
			e.printStackTrace();
			note = "no";
		}
		return note;
	}
	public HashMap<String,Integer> getFavouriteList (){
		/**
		 * This method returns all the wine in the favourite list
		 */
		HashMap<String,Integer> wineList = new HashMap<String,Integer>();
		try{
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from [FavouriteList]");
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()){	
				wineList.put(Integer.toString(rs.getInt("Wine_ID")),rs.getInt("Ranking"));
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return wineList;	

	}
	public String removeList(String wineID){
		/**
		 * This method removes the wine from the favourite list
		 */
		String note = "";
				try{
					PreparedStatement preparedStatement;
					double Wine_ID = Double.parseDouble(wineID);
					preparedStatement = connection.prepareStatement("DELETE FROM FavouriteList WHERE Wine_ID="+Wine_ID);
					note="frik";
					preparedStatement.executeUpdate();
					
					
					
				} catch (SQLException e){
					e.printStackTrace();
					note="no no";
				}
				return note;
	}
	public String updateList(Integer favId, Integer wineId){
		/**
		 * This method updates the favourite list
		 */
		String note = "";
		try{
			PreparedStatement preparedStatement;
			double Wine_ID = Double.valueOf(wineId);
			preparedStatement = connection.prepareStatement("UPDATE FavouriteList SET Ranking ="+favId+" WHERE Wine_ID ="+Wine_ID);
		
			note="frik";
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e){
			e.printStackTrace();
			note="no no";
		}
		return note;
	}

	
}
