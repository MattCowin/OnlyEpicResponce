ApproveRequest.addEventListener("click", function (ev) {
    alert('btn 1 clicked');
    ev.stopPropagation();
}, true);


const approveReq = () => {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () =>{
		if(xhr.status === 200 && xhr.readyState === 4){
			
			let json = JSON.parse(xhr.responseText);
			console.log(json);
			populateReimbursementsTable(json);
		}
	};
	xhr.open("GET", "http://localhost:8088/OnlyEpicRequest/UpdateReimbursementById");
	xhr.send();
}

