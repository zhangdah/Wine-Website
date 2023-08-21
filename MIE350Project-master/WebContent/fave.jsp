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
	<%@ include file="navbar.jsp"%>
	 <h1 class="page-title">Updated Favourite List</h1>
	 <div class='container' style="width:60vw;text-align:center">
	</div>
     <c:forEach items="${favList}" var="favList">
		<div class='container' style="width:60vw">
			<div class="row">
				<div class="col-lg-3" style="text-align:center">
				<p>${favList.getFavId()}</p>
					<img src="${favList.getWinePicURL() }" class='Wineicon' style="max-height:200px">			
				</div>			
				<div class="col-lg-9" >
					<h4>${favList.getWineName()}</h4>
					<div > ${favList.getWineDescription()}</div>
					<br>
					<p>Price: <b>$${favList.getPrice() } CAD</b></p>
					
					<Form id = "FavList" action="FavouriteController" method="post">
				  	
		         	<input type = "hidden" name = "favAction" id = "favAction" value = "Remove"/>
		         	<input type = "hidden" name = "favwine" id = "favwine" value = "${favList.getWineid()}"/>
		         	<input class="buttonT" type="submit" value="Remove from List"/>
		         	</Form> 
				</div>
				
			</div>	
			<hr>
		</div>
	</c:forEach> 
<script src="js/compare.js" ></script>
<script src="js/index.js" ></script>

</body>
</html>
