//ApproveRequest.addEventListener("click", function (ev) {
//    alert('btn 1 clicked');
//    ev.stopPropagation();
//}, true);


const pushRequest = () => {
	const xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = () =>{
		if(xhr.status === 200 && xhr.readyState === 4){
			
			let json = JSON.parse(xhr.responseText);
			console.log(json);
			
		}
	};
	xhr.open("POST", "http://localhost:8088/OnlyEpicRequest/UpdateReimbursementById");
	xhr.send(app);
}


function approveReq(){
const app = document.getElementById("tr").firstChild.innerHTML;

}

function denyReq(){
	const app = document.getElementById("tr").firstChild.innerHTML;
	

	}

