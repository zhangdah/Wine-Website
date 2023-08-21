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



<link rel="stylesheet" type="text/css" href="css/navstyle.css">
<link rel="stylesheet" type="text/css" href="css/compare.css">
</head>

<body>
	
	<%@ include file="navbar.jsp"%>
	
	 <h1 class="page-title">Compare Wines</h1>
		
		
	  <div class="width:80%;">
	 
        <table>
            <tr>
                <th id="attr"></th>
                <c:forEach items="${wineList}" var="wine">
                <th style="text-align:center" id="one"> 
                    <img src="${wine.getWinePicURL()}" style="max-width:70%">
                </th>
				</c:forEach> 
                
            </tr>
             <tr >
                <td>
                    <p>Name</p>
                </td>
             	 <c:forEach items="${wineList}" var="wine">
                <td> 
                    <p>${wine.getWineName()}</p>
                </td>
				</c:forEach> 
            </tr>
            <tr class="active">
                <td>
                    <p>Region</p>
                </td>
             	 <c:forEach items="${wineList}" var="wine">
                <td> 
                    <p> ${wine.getRegion()}</p>
                </td>
				</c:forEach> 
            </tr>
            <tr >
                 <td>
                    <p>Description</p>
                </td>
             	 <c:forEach items="${wineList}" var="wine">
                <td> 
                    <p>${wine.getWineDescription()}</p>
                </td>

				</c:forEach> 
            </tr>
             <tr class="active">
                 <td>
                    <p>Wine Type</p>
                </td>
             	 <c:forEach items="${wineList}" var="wine">
                <td> 
                    <p>${wine.getWineType()}</p>
                </td>

				</c:forEach> 
            </tr>
             <tr >
                 <td>
                    <p>Sweetness</p>
                </td>
             	 <c:forEach items="${wineList}" var="wine">
                <td> 
                    <p>${wine.getSweetness()}</p>
                </td>

				</c:forEach> 
            </tr>
             <tr class="active">
                 <td>
                    <p>Occasion</p>
                </td>
             	 <c:forEach items="${wineList}" var="wine">
                <td> 
                    <p>${wine.getOccasion()}</p>
                </td>

				</c:forEach> 
            </tr>
             <tr >
                 <td>
                    <p>Taste</p>
                </td>
             	 <c:forEach items="${wineList}" var="wine">
                <td> 
                    <p>${wine.getTaste()}</p>
                </td>

				</c:forEach> 
            </tr>
          
        </table>
    </div>
      
<script src="js/compare.js" ></script>
<script src="js/index.js" ></script>

</body>
</html>
