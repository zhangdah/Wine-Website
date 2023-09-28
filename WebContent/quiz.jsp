<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Wine,Simplified | Quiz</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.gstatic.com"> 
<link href="https://fonts.googleapis.com/css2?family=DM+Serif+Display&family=Roboto:wght@300;400&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<link rel="stylesheet" type="text/css" href="css/wineProfileStyle.css">
<link rel="stylesheet" type="text/css" href="css/navstyle.css">
</head>
<body>
	<%@ include file="navbar.jsp"%>
	 
    <div style="margin:auto;left:0;right:0;width:600px;">
     <h1 class="page-title">Wine Quiz</h1>
     <p>This quiz is designed to help you figure out what wine you want to drink !</p>
    <form id = "quizForm" action = "FilterController">
        <h4 class = "Q">1. What type of wine are you looking for?</h4>
        <div style="margin:20px 0px">
        <span class="type-button" id="Red" onclick="quizToggle('Red','Wine')">Red Wine</span>
        <span class="type-button" id="White" onclick="quizToggle('White','Wine')">White Wine</span>
        <span class="type-button" id="Ice" onclick="quizToggle('Ice','Wine')">Ice Wine</span>
        <span class="type-button" id="Champagne" onclick="quizToggle('Champagne','Wine')">Champagne</span>
        </div>
        <h4 class = "Q">2. What occasion is this for?</h4>
        <div style="margin:20px 0px">
        <span class="type-button" id="Dessert" onclick="quizToggle('datenight','Occasion')">Dessert</span>
        <span class="type-button" id="Dinner" onclick="quizToggle('Dinner','Occasion')">Dinner</span>
        <span class="type-button" id="Party" onclick="quizToggle('Party','Occasion')">Celebration</span>
        <span class="type-button" id="Brunch" onclick="quizToggle('Brunch','Occasion')">Brunch</span>
        <span class="type-button" id="Cooking" onclick="quizToggle('Cooking','Occasion')">Cooking</span>
        </div>
        <h4 class = "Q">3. Which taste do you prefer?</h4>
        <div style="margin:20px 0px">
        <span class="type-button" id="Citrus" onclick="quizToggle('Citrus','Taste')">Citrus</span>
        <span class="type-button" id="Floral" onclick="quizToggle('Floral','Taste')">Florals</span>
        <span class="type-button" id="Fruity" onclick="quizToggle('Fruity','Taste')">Fruity</span>
        </div>
        <h4 class = "Q">4. On a scale of 1 - 4, how sweet do you enjoy your drinks?</h4>
        <div style="margin:20px 0px">
        <input type="radio" name="sweet"  value = "'S'"> S
        <input type="radio" name="sweet"  value = "'M'"> M
        <input type="radio" name="sweet"  value = "'D'"> D
        <input type="radio" name="sweet"  value = "'XD'"> XD
        </div>
        <h4 class = "Q">Q5. What is your Price Range?</h4>
        <input type="radio" name="price"  value = "$"> $
        <input type="radio" name="price"  value = "$$"> $$
        <input type="radio" name="price"  value = "$$$"> $$$
        <p class = "empty"><p>
        <input type = "hidden" name = "wineType" id = "wineType"/>
        <input type = "hidden" name = "occasion" id = "occasion"/>
        <input type = "hidden" name = "taste" id = "taste"/>
        <button class="find-button" id="findWine" onclick ="send()">Find Wine</button>
	
    </form>
    </div>
	
    <script  src="js/quiz.js"></script>         
</body>
</html>