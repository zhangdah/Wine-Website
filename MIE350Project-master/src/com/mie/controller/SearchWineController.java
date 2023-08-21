package com.mie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.WineDao;
import com.mie.model.Wine;
import com.mie.model.WineType;

public class SearchWineController extends HttpServlet{
	/**
	 * This class deals with the search input in catalogue
	 */
	private WineDao dao;
	protected final String SEARCH_RESULT = "/catalogue.jsp";
	
	public SearchWineController(){
		super();
		dao = new WineDao();
	}

	public String testMethod(){
	    return "Hello";
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method handles the keyword input and forward the winelist
		 */
		String forward = SEARCH_RESULT;
		String keyword = request.getParameter("keyword");
			
		ArrayList<Wine> winelist = new ArrayList<Wine>();
		winelist = dao.getWineByKeyword(keyword);
		
		request.setAttribute("wineList", winelist);
		
        if (winelist.size()==0){
        	request.setAttribute("message","The website has nothing matches the keywords <br/>");
        } else {
        	request.setAttribute("message","Found " + winelist.size() + " items that matches the keywords <br/>");
        }
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}
