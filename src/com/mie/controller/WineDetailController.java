package com.mie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.WineDao;
import com.mie.model.Wine;

public class WineDetailController extends HttpServlet {
	/**
	 * This class is for displaying individual wine info
	 */
	protected final String WINE_PROFILE = "/WineProfile.jsp";
	protected WineDao dao;
	
	public WineDetailController() {
		super();
		dao = new WineDao();
	}
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method handles the action input and forward detailed information on the wine
		 */
		String forward = "";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listWineDetail")){
			forward = WINE_PROFILE;
			String wineid = request.getParameter("wineID");
			Wine wine = dao.getWineNameByID(wineid);
			
			request.setAttribute("wine", wine);
			
			
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
			
			
		}
	}
}
