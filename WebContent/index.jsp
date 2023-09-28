<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import = "com.mie.*" isELIgnored="false"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Wine,Simplified</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.gstatic.com"> 
<link href="https://fonts.googleapis.com/css2?family=DM+Serif+Display&family=Roboto:wght@300;400&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/0e82f7c742.js" crossorigin="anonymous"></script>



<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<link rel="stylesheet" type="text/css" href="css/navstyle.css">
<link rel="stylesheet" type="text/css" href="css/compareBar.css">
</head>

<body>
	<c:import url="/TestController" />
	<c:set var="wineList" value="${requestScope.wineList}" />
	<%@ include file="navbar.jsp"%>
	 <h1 class="page-title">Welcome to Wine, Simplified</h1>
	 <div class="container">
	 <p>As a MIE350 project team consisting of 7 third-year Industrial Engineering students from the University of Toronto, we have been tasked to design a web-based application. Our web application aims to develop a wine information and recommendation site which helps users select their desirable wine. The website will be mainly catered towards novice wine consumers and will aid them in their decision-making process. The application will provide detailed information about the wines and wineries, and allow users to search, filter, compare, and save their desired wines. The website will act as an information site which will promote the wines, guide users on purchasing, and potentially show wine ratings having an overall effect on wine sales.
	 </p>
	 <p>In Canada, wine consumption has increased over the past few years, which indicates that wine has become more popular and important among the population. This has led to an increased demand for wine purchasing.</p>
	<p>However, the gap which currently exists in wine purchasing and information sites is that they lack a user-friendly interface for inexperienced wine consumers, which makes it difficult for these users to decide which wine to purchase. </p>

	<p>nstead, potential wine buyers, especially novice wine consumers tend to rely on directly consulting the store staff for detailed guidance and personalised recommendations. However, this requires time and patience on the buyer¡¯s part to personally visit the store, as well as to communicate their preferences to the staff. Given the limited time they have at the store and the hundreds of wine options available, the buyers can be easily overwhelmed by the information and may not choose the best option for their preferences and the occasion. More often than not, they don¡¯t actually know the difference between the many options available. As well, to consult the store staff, the buyer needs to meet the staff in-person, which is not ideal especially during this pandemic.</p>
	</div>
      
<script src="js/compare.js" ></script>
<script src="js/index.js" ></script>

</body>
</html>
