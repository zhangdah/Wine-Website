function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
  console.log("help");
}

function toggle(id){
  var e = document.getElementById(id);
  if(e.style.display == 'block')
     e.style.display = 'none';
  else
     e.style.display = 'block';
}

var faveList = [9,10,11]

function addFav(id){
	var item = document.getElementById(id);  
	console.log();
	item.children[2].submit();
}

function toggleHeart(id,action){
	
	var e = document.getElementById(id);
	var fill = e.children[1].children[1];
	console.log(fill)
	var modal = document.getElementById("custom")
	
	if(fill.classList.contains("noShow") == false){
		fill.classList.add("noShow");
		console.log(fill);
		for(var i = 0; i < faveList.length; i++){
			if(faveList[i] == id){
				faveList.splice(i, i+1)
			}
		}
		console.log(faveList);
	}
	else if(fill.classList.contains("noShow")){
		console.log(fill.classList);
		fill.classList.remove("noShow");
		faveList.push(id);
		//addFav(id);
		openModal(id);
		modal.classList.add("showModal");
		console.log(faveList);
	}
}
function openModal(id){
	var outer = document.createElement("div");
	outer.setAttribute("class","cstmmodal");
	outer.setAttribute("id","custom");
	var inner = document.createElement("div");
	inner.setAttribute("class","innermodal");
	
	var text = document.createElement("h5");
	text.innerHTML = "Are you sure you want to add wine to your favourite list?";
	var btn1 = document.createElement("button");
	btn1.innerHTML = "Yes";
	btn1.setAttribute("onclick","addFav("+id+")");
	var btn2 = document.createElement("button");
	btn2.innerHTML = "No";
	btn2.setAttribute("onclick","closeModal()");
	
	inner.appendChild(text);
	inner.appendChild(btn1);
	inner.appendChild(btn2);
	outer.appendChild(inner);
	var winepage = document.getElementById("target");
	winepage.appendChild(outer);

}

function closeModal(){
	var obj = document.getElementById("custom");
	obj.remove();
	return no;
}
