function quizToggle(id,category){
  var e = document.getElementById(id);

  for(var key in dict){
    if(key == category){
      if(!dict[key].includes(id)){
        dict[key].push(id);
      }
      else{
        var j;
        for(j = 0; j < dict[key].length; j++){
          if(dict[key][j] == id){
            dict[key].splice(j,1);
          }
        }
      }
    }
  }

  console.log(dict)
  e.classList.toggle("unactive")
}

var dict = new Object();
var dict = {
  Wine:[],
  Occasion:[],
  Taste:[]
}

function send(){
    
    var A = document.getElementById("wineType");
    var B = document.getElementById("occasion");
    var C = document.getElementById("taste");

    A.value = "'" + dict["Wine"].join("','") + "'";
    B.value = "'" + dict["Occasion"].join("','") + "'";
    C.value = "'" + dict["Taste"].join("','") + "'";
    
    // Submit the form using javascript
    var form = document.getElementById("quizForm");
    form.submit();
}

function price(Id){
	var e = document.getElementById(Id);
	document.quizForm.price.value = Id;
}
