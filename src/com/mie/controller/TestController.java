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
import com.mie.model.Wine;

public class TestController extends HttpServlet{
		/**
		 * This class only loads all wine
		 */
		private WineDao dao;

		/**
		 * Constructor for this class.
		 */
		public TestController() {
			super();
		}
		


		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			/**
			 * This method handles the loading all wines when catalogue first load in.
			 */
			WineDao dao = new WineDao();
			request.setAttribute("wineList",dao.getAllWines());

		}		
}
	

