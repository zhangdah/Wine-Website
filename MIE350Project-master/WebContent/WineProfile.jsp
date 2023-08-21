<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Wine, Simplified</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.gstatic.com"> 
<link href="https://fonts.googleapis.com/css2?family=DM+Serif+Display&family=Roboto:wght@300;400&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<link rel="stylesheet" type="text/css" href="css/navstyle.css">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<link rel="stylesheet" type="text/css" href="css/wineProfileStyle.css">
</head>
<body>
<%@ include file="navbar.jsp"%>
<div id="wine-profile">
        <div>
			
		 	<div class="row" style="width:1000px;margin:auto;left:0;right:0;padding-top:50px">
		 		<div class="col-lg-4 col-md-4">
		 			<img class="disp" src="${wine.getWinePicURL()}" style="height:70vh;"> 
		 		</div>
		 		<div class="col-lg-8 col-md-8">
		 			<h1 class = "wine-title">${wine.getWineName()}</h1>
		 			<p class = "location" > Red wine from <b> ${wine.getRegion()} </b></p>
				<p class = "price" style="display:inline"> Price: <b>$ ${wine.getPrice()}</b> </p>
				<p class = "rating" style="display:inline;padding-left:50px">Rating:<b> ${wine.getWineRating()} </b>| ${wine.getRatingCount()} Ratings</p>
				<br>
				<br>
				<Form id = "FavList" action="FavouriteController" method="post">
				  	
		         	<input type = "hidden" name = "favAction" id = "favAction" value = "AddOne"/>
		         	<input type = "hidden" name = "favwine" id = "favwine" value = "${wine.getWineid()}"/>
		         	<input class="buttonT" type="submit" value="Add to Favourite List"/>
		         </Form> 
		         <br>
				<p>Description</p>
				<p class = "description"> ${wine.getWineDescription()} </p>
				<p class = "facts"><b> Facts About the wine</b> </p>
				<br>
				<p class = "wine-type"> Wine Type: ${wine.getWineType()} </p>
				<p class = "winery"> Winery: ${wine.getWinery()} </p>
				<p class = "region"> Region: ${wine.getRegion()} </p>
				<p class = "year"> Year: ${wine.getYear()} </p>
				<p class = "bottle-size"> Bottle Size: ${wine.getBottleSize()} </p>
				<p class = "alcohol-content"> Alcohol Content: ${wine.getAlcoholLevel()} </p>
				<p class = "sugar-content"> Sugar Content: ${wine.getSugarContent()} </p>
				<p class = "sweetness-description"> Sweetness: ${wine.getSweetness()} </p>
				<p class = "occasion"> Occasion: ${wine.getOccasion()} </p>
				<p class = "taste"> Taste: ${wine.getTaste()} </p>
			 		</div>
		 	</div>
			
        	
		 </div>
          
           
 </div>
 <script>

 </script>
</body>
</html>