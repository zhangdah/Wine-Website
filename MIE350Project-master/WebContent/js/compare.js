function compareToggle(str){
  var e = document.getElementById("compare");
  console.log(e);

  if(str == "tab"){
    e.classList.toggle("showComp")
  }

  else{
    if(!e.classList.contains("showComp")){
      e.classList.add("showComp")
    }
  }
}


var compareList = [];

// preventing duplicate
function addcompareList(str){
  if(compareList.length < 3 && !compareList.includes(str)){
    compareList.push(str)
  }
  console.log(compareList)
}

function removecompareList(str){
  var i;
  var num;
  for(i = 0; i < compareList.length;i++){
    if(compareList[i]==str ){
      num = i;
    }
  }
  if(compareList.length != 0){
    //delete compareList[num]
    compareList.splice(num,1)
  }
  
  console.log(compareList);
  var compareSection = document.getElementById('wineList');
  compareSection.removeChild(compareSection.children[num]);
  
  if(compareList.length == 0){
      var btnSection = document.getElementById('compContent');
      console.log(btnSection)
      btnSection.removeChild(btnSection.children[1]);
      var filler = document.createElement("h4");
      filler.innerHTML ="To compare wines, click the 'Compare' button to add to the compare selection.";
      filler.setAttribute("id","filltext");
      btnSection.appendChild(filler)
  }
 
}

function addtoCompare(id){
  //change styling when button is clicked 
  // getting name of the child 
  var wineName = document.getElementById(id).children[2].innerHTML;
  var fillText = document.getElementById('filltext');
 
  // adding to local data storage
  console.log(!compareList.includes(id));
  if(compareList.length < 3 && !compareList.includes(id)){
    //keep track of data in array
    compareList.push(id);
    console.log(compareList);
    var container = document.createElement("div");
    var x = document.createElement("img");
    var y = document.createElement("div");
    var z = document.createElement("p");
    
    container.setAttribute("class","compCont");
    x.setAttribute("class","removeCont");
    x.setAttribute("src","img/x.png");
    x.setAttribute("onclick","removecompareList('"+id+"')")
    y.setAttribute("class","innerCont");
    z.innerHTML = wineName;
    y.appendChild(z);
    container.appendChild(x);
    container.appendChild(y);
  }
 
  var btn;
  if(compareList.length < 2){
	form = document.createElement("Form");
	form.setAttribute("id","compareForm");
	form.setAttribute("action","CompareController");
	form.setAttribute("method","post")
	
	inpt = document.createElement("input");
	inpt.setAttribute("type","hidden");
	inpt.setAttribute("name","compareList");
	inpt.setAttribute("id","compList");
	
    btn = document.createElement("button");
    btn.setAttribute("class","comparebtn");
    btn.setAttribute("id","comp")
    btn.innerHTML = "Compare"

    	
    btn.setAttribute("onclick","setCompareVals()")
    tag = document.createElement("a");
    tag.setAttribute("href","wineCompare.jsp")
    var compareSection = document.getElementById('compContent');
    tag.appendChild(btn);
    form.appendChild(inpt);
    form.appendChild(tag);
   
    compareSection.appendChild(form);
    console.log(compareSection.children[1])
    compareSection.removeChild(compareSection.children[1])
    console.log(btn)
  }
  
  var wineSec = document.getElementById('wineList');
  wineSec.appendChild(container);


  compareToggle("wine");

}
function setCompareVals(){
	var e = document.getElementById("compList");
	console.log(compareList)
	e.value =  compareList
	
	var form = document.getElementById("compareForm");
	console.log(form);

    form.submit();
}

