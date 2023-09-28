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

<script src="js/index.js" ></script>

<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<link rel="stylesheet" type="text/css" href="css/navstyle.css">
<link rel="stylesheet" type="text/css" href="css/catalogue.css">
<link rel="stylesheet" type="text/css" href="css/compareBar.css">
</head>

<body>
	
	<div id="target"></div>
	<%@ include file="navbar.jsp"%>
	
<div id="wine-display">
		<div id="compare" >
            <div id="compBtn" onclick="compareToggle('tab')" >Compare List</div>
            <div id="compContent">
                <div id="wineList">

                </div>
               
                <p id="filltext">To compare wines, click the "Compare" button to add to the compare selection. </p>
            </div>
        </div>
		

	<!-- 	<div class="cstmmodal" id="custom" >
			<div class="innermodal">
				<h5>Are you sure you want to add wine to your favourite list?</h5>
				<button>Yes</button>
				<button>No</button>
			</div>
		</div > -->
        <div>
        <h1 class="page-title">Wine Catalogue</h1>
      
        <table>
            <tr>
            <form action = "FilterController" method = "Post">
            
                <td>
                    <div class="outer-div" >
                        <div onclick="toggle('winetype')" class="testbtn">Wine Type</div>
                        <div id="winetype" class="dropdown-content">
                            <div class="options">
                            <input type="checkbox" id="wineType" name="wineType" value="Red" >
                            <label>Red Wine</label>             
                            </div>
                            <div class="options">
                            <input type="checkbox" id="wineType" name="wineType" value="White" >
                            <label>White Wine</label>
                            </div>
                            <div class="options">
                            <input type="checkbox" id="wineType" name="wineType" value="Ice">
                            <label>Ice Wine</label><br>
                            </div>
                            <div class="options">
                            <input type="checkbox" id="wineType" name="wineType" value="Champagne">
                            <label>Champagne</label><br>
                            </div>
                        </div>
                        </div>
                </td>
                <td>
                    <div class="outer-div" >
                        <div onclick="toggle('occasion')" class="testbtn">Occasion</div>
                        
                        <div id="occasion" class="dropdown-content">
                            <div class="options">
                            <input type="checkbox" id="occasion" name="occasion" value="Brunch">
                            <label>Brunch</label>
                            </div>
                            <div class=" ">
                            <input type="checkbox" id="occasion" name="occasion" value="Dinner">
                            <label>Dinner</label>
                            </div>
                            <div class="options">
                            <input type="checkbox" id="occasion" name="occasion" value="Dessert">
                            <label>Dessert</label><br>
                            </div>
                            <div class="options">
                            <input type="checkbox" id="occasion" name="occasion" value="Cooking">
                            <label>Cooking</label><br>
                            </div>
                            <div class="options">
                            <input type="checkbox" id="occasion" name="occasion" value="Party">
                            <label>Celebration</label><br>
                            </div>
                        </div>
                     </div>
                </td>
                <td>
                    <div class="outer-div" >
                        <div onclick="toggle('taste')" class="testbtn">Taste</div>
                        
                        <div id="taste" class="dropdown-content">
                            <div class="options">
                            <input type="checkbox" id="taste" name="taste" value="Fruity">
                            <label>Fruity</label>
                            </div>
                            <div class="options">
                            <input type="checkbox" id="taste" name="taste" value="Floral">
							<label>Floral</label>
                            </div>
                            <div class="options">
                            <input type="checkbox" id="taste" name="taste" value="Citrus">
                            <label>Citrus</label>
                            </div>
                        </div>
                        </div>
                </td>
                <td>
                	<div class="outer-div" >
                        <div onclick="toggle('sweetness')" class="testbtn">Sweetness</div>
                        
                        <div id="sweetness" class="dropdown-content">
                            <div class="options">
                            <input type="checkbox" id="sweetness" name="sweetness" value="S">
                            <label>Sweet</label>
                            </div>
                            <div class="options">
                            <input type="checkbox" id="sweetness" name="sweetness" value="M">
							<label>Mild</label>
                            </div>
                            <div class="options">
                            <input type="checkbox" id="sweetness" name="sweetness" value="D">
                            <label>Dry</label>
                            </div>
                             <div class="options">
                            <input type="checkbox" id="sweetness" name="sweetness" value="XD">
                            <label>Extra Dry</label>
                            </div>
                        </div>
                        </div>
                </td>
                
             
                <td>
                    <div class="outer-div" >
                        <div onclick="toggle('price')" class="testbtn">Price</div>
                        
                        <Select name = "price">
                        	<option value="''">Choose Price Range...</option>
                        	<option value="$">Less than $20</option>
                        	<option value="$$">Between $20 to 50$</option>
                        	<option value="$$$">More than $50</option>
                        </Select>
                        </div>
                </td>
                <input type="submit" value="Submit Filter Input"/>
             </form>
                <td>
                    <div class="outer-div" >
                    <form action="SearchWineController" method="post">
                        <input type="text" name="keyword" class="searchTerm" placeholder="Search Wine Name" id="searchFunc">
                        <button type="submit" value="SearchWineController" style="border: 0; background-color: white;" class="searchButton">
                        <i class="fa fa-search"></i>
                        </button>
					</form>
                    </div>
                   
				</td>
            </tr>
        </table>
        
        </div>
        
        <div id="winecontainer"> 
   
        <div class="row">
        	<c:forEach items="${wineList}" var="wine">
        		<div class="col-lg-3 col-xl-3 col-md-4 col-sm-6">
        		
                <div class="wine-card" id="${wine.getWineid()}">
                   <button onclick="addtoCompare(${wine.getWineid()})"  class="compbtn" style="border:none;
					  background-color:#5A0E32;
					  color:white;
					  padding:5px 10px;;
					  border-radius:100px;">Compare</button>
					<!--  
					 <div onclick="toggleHeart(${wine.getWineid()},'Add')" style="display:inline">
                     <img  class="heart empty" src="img/heart.png" />
                     <img class="heart filled noShow" src="img/heartfilled.png"/>
                	</div>
                	<Form id = "FavList" action="FavouriteController" method="post">
		         		<input type = "hidden" name = "favAction" id = "favAction" value = "AddOne"/>
		         		<input type = "hidden" name = "favwine" id = "favwine" value = "${wine.getWineid()}"/>
		         	</Form> 
                 -->
               <a href="WineDetailController?action=listWineDetail&wineID=${wine.getWineid()}">
                <div style="width:100%;text-align:center">
                <img src="${wine.getWinePicURL()}" style="text-algin:center;max-height:300px;max-width:20vw;padding:20px;">
                </div>
                </a>
                <h4>${wine.getWineName()}</h4>
                </div>
                
            	</div>
        	</c:forEach>
        </div>
        
        </div>
     </div>
     <div>
     	<p>		${message}</p>
     </div>

   	
      
<script src="js/compare.js" ></script>


</body>
</html>
