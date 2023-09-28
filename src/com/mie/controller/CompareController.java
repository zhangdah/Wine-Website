package com.mie.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.WineDao;
import com.mie.model.Wine;

public class CompareController extends HttpServlet {
private WineDao dao = new WineDao(); 


	public CompareController(){
		super();
		dao = new WineDao();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method handles the retrieval of the search keyword entered by
		 * the user.
		 */
		
		PrintWriter writer = response.getWriter();
		
		String[] comp = request.getParameterValues("compareList");
		
		//PrintWriter writer = response.getWriter();   
		String compare = tokenize(comp);
		
		
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String[] comp = request.getParameterValues("compareList");
		String [] compArr = comp[0].split(",");
		ArrayList<Wine> compOpt = new ArrayList<Wine>();
		
		for(String i:compArr){
			Wine temp = dao.getWineNameByID(i);
			compOpt.add(temp);
		}
		
		
		request.setAttribute("wineList",compOpt);
	    
	    
	    RequestDispatcher view = request.getRequestDispatcher("/wineCompare.jsp");
		
		view.forward(request, response);
		
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
