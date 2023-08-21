package com.mie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.WineDao;
import com.mie.model.*;

public class FilterController extends HttpServlet {
	
	private WineDao dao = new WineDao();
	
	public FilterController(){
		super();
		dao  = new WineDao();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method handles the quiz input of the filter wines
		 */
		PrintWriter writer = response.getWriter();

		String wineType = request.getParameter("wineType");
		String occasion = request.getParameter("occasion");
		String taste = request.getParameter("taste");
		String sweet = request.getParameter("sweet");
		String price = request.getParameter("price");
		if(price == null){
			price = "''";
		}
		if(sweet == null){
			sweet = "''";
		}
		ArrayList<Wine> wineList = dao.getWineByFilter(wineType, occasion, taste, sweet, price);
		if(wineList.isEmpty()){
			request.setAttribute("message", "No wine found.");
			RequestDispatcher view = request.getRequestDispatcher("/filterResults.jsp");
			
			view.forward(request, response);
		}else{
			request.setAttribute("wineList", wineList);
			RequestDispatcher view = request.getRequestDispatcher("/filterResults.jsp");
			
			view.forward(request, response);
		}		
	}	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method handles filter inputs in the checkbox seletion in catalogue
		 */
		PrintWriter writer = response.getWriter();
		String[] wineType = request.getParameterValues("wineType");
		String[] occasion = (String[])request.getParameterValues("occasion");
		String[] taste = (String[])request.getParameterValues("taste");
		String[] sweet = request.getParameterValues("sweetness");
		String price = request.getParameter("price");  
		String toe = "''";
		String occ = "''";
		String tas = "''";
		String swee = "''";
		if(wineType != null){
			toe = tokenize(wineType);
		}
		if(occasion != null){
			occ = tokenize(occasion);
		}
		if(taste != null){
			tas = tokenize(taste);
		}
		if(sweet != null){
			swee = tokenize(sweet);
		}

		ArrayList<Wine> wineList = dao.getWineByFilter(toe, occ, tas, swee, price);

		if(wineList.isEmpty()){
			request.setAttribute("message", "No wine found.");
			RequestDispatcher view = request.getRequestDispatcher("/filterResults.jsp");
			
			view.forward(request, response);
		}else{
			request.setAttribute("wineList", wineList);
			RequestDispatcher view = request.getRequestDispatcher("/filterResults.jsp");
			
			view.forward(request, response);
		}
		
	}	
	
	
	private String tokenize(String [] str_list){
		String token = "";
		for (int i =0; i < str_list.length; i++){
			if(i == str_list.length -1){
				token = token + "'" + str_list[i] + "'";
			}else{
				token = token + "'" + str_list[i] + "',";
			}
		}
		return token;
	}
}
