package com.mie.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.mie.dao.FavoriteListDao;
import com.mie.dao.WineDao;

public class FavoriteList {

	private String userId;
	private ArrayList <Wine> favoriteList;
	//private HashMap<Integer,Wine> favList = new HashMap<Integer,Wine>();
	private WineDao dao = new WineDao();
	private FavoriteListDao favdao = new FavoriteListDao();
	
	public FavoriteList(){
		//favList =  new HashMap<Integer,Wine>();
		favoriteList = new ArrayList <Wine>();
		dao = new WineDao();
	}
	
	public Wine getWine(Integer id){
		Wine output = new Wine();
		for(Wine obj: favoriteList){
			if(obj.getWineid() == id){
				output = obj;
			}
		}
		return output;
	}
	public void addFavouriteList(Integer listId,String wineId){
		Wine temp = new Wine();
		temp = dao.getWineNameByID(wineId);
		temp.setFavId(listId);
		if(this.containsWine(favoriteList, wineId)== false){
			String ugh = favdao.addWine(wineId,listId);
			favoriteList.add(temp);
			
		}
		
	}
	
	public ArrayList<Wine> getFavouriteList(){
		HashMap<String,Integer> tempList = favdao.getFavouriteList();
		//ArrayList<Wine> favWineList = new ArrayList<Wine>();	
		for (String key : tempList.keySet()){
			this.addFavouriteList(tempList.get(key),key);;
		}
		
		return favoriteList;
	}
	
	public boolean containsWine(ArrayList<Wine> list,String id){
		boolean output = false;
		for(Wine wine: list){
			if(wine.getWineid() == Integer.parseInt(id)){
				output = true;
				break;
			}
		}
		return output;
	}

	public void remove(String id){
		getFavouriteList();
		Wine obj = getWine(Integer.valueOf(id));
		Integer favid = (Integer) obj.getFavId();
		updateOrder(favid);
		favdao.removeList(id);

	}
	
	public ArrayList<Wine> sortFavouriteList(){
		
		  
		  List<Wine> sortedList = new ArrayList<Wine>(favoriteList);
		  Collections.sort(sortedList, new Comparator<Wine>() {
		          public int compare(Wine w1, Wine w2) {
		             return Integer.valueOf(w1.getFavId()).compareTo(w2.getFavId());
		          }
		  });  
		  return (ArrayList<Wine>) sortedList;
	}
	
	
	public void updateOrder(Integer id){

		favoriteList = getFavouriteList();
		
		for(Wine wine: favoriteList){
		
			if(wine.getFavId() > id){
				Integer favId = (wine.getFavId() - 1);
				Integer wineId = wine.getWineid();
				favdao.updateList(favId,wineId);
			}
		};
	}
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	public ArrayList <Wine> getfavoriteList() {
//		return favoriteList;
//	}
//	public void setfavoriteList(ArrayList <Wine> favoriteList) {
//		this.favoriteList = favoriteList;
//	}
//	
//	public void addWine (Wine wine){
//		this.favoriteList.add(wine);
//	}
//	
//	public void removeWine (Wine wine){
//		this.favoriteList.remove(wine);
//	}
//	
//	public void removeWine (Integer index){
//		this.favoriteList.remove(index);
//	}
}
