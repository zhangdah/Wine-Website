package com.mie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.WineDao;
import com.mie.dao.FavoriteListDao;
import com.mie.model.*;

public class FavouriteController extends HttpServlet {
	
	private FavoriteListDao favdao = new FavoriteListDao();
	private ArrayList<Wine> favWineList = new ArrayList<Wine>();
	private WineDao dao = new WineDao();
	private FavoriteList list;
	public FavouriteController(){
		super();
		favdao = new FavoriteListDao();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method handles the favourite list of wine stored and push it to frontend
		 */
		
		list = new FavoriteList();
		
		list.getFavouriteList();

		request.setAttribute("favList",list.sortFavouriteList());
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		String action = request.getParameter("favAction");
		favWineList = new ArrayList<Wine>();		
		RequestDispatcher view;

		if(action.equals("AddOne")){
			
			list = new FavoriteList();
			
			String wineId = (String) request.getParameter("favwine");
			
			ArrayList<Wine> faveList = list.getFavouriteList();
			list.addFavouriteList((faveList.size() + 1), wineId);
		
			request.setAttribute("favList",list.sortFavouriteList());
			view = request.getRequestDispatcher("/fave.jsp");
			view.forward(request, response);
			
		}
		else if(action.equals("Remove")){
			String wineId = (String) request.getParameter("favwine");
			list = new FavoriteList();
			list.remove(wineId);

			FavoriteList newList = new FavoriteList();
			newList.getFavouriteList();
			
			request.setAttribute("favList",newList.sortFavouriteList());
			view = request.getRequestDispatcher("/fave.jsp");
			view.forward(request, response);
		}
	
				
		
	}
}
