/**
 * Author: Matt Cowin
 */

function get(url){
	return new Promise((resolve, reject) =>{
		let xhr =new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				resolve(JSON.parse(xhr.response));
			}
			else{
				reject(Error("Oops. Something went wrong."));
			}
		}
		
		
		
		
		xhr.open("GET", url);
		xhr.send();
	}
	)
}
//Need this function to populate the reimbursments form
function getReimbursmentRequest(){
	let url = "../reimbursments.html";
	
	let selectBox = document.getElementById("selectBox");
	let results = get(url).then(data => {
		console.log(data);
		//enhanced for loop in JavaScript
		for(let d in data){
			let option = document.createElement("option");
			option.innerHTML = data[d]["name"];
			option.value = data[d]["id"];
			selectBox.append(option);
		}
	}).catch(error =>{
		console.lot("Hey, where's my data?")
	});
}

function backTo(){
	document.location.replace("../index.html");
}

function submit(){
	
}

