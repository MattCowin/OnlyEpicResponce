

const disInfo = (xhr) => {
	tableRows = xhr.responseText;
	let table = document.getElementById("ReimbursementsTable");
	table.removeChild(document.getElementById("reimbursementbody"));
	let newBody = document.createElement("tbody");
	newBody.setAttribute("id", "reimbursementbody");
	newBody.innerHTML = tableRows;
	table.appendChild(newBody);
	
}

const getAllReimbursements = () => {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () =>{
		if(xhr.status === 200 && xhr.readyState === 4){
			
			let json = JSON.parse(xhr.responseText);
			console.log(json);
			populateReimbursementsTable(json);
		}
	};
	xhr.open("GET", "http://localhost:8088/OnlyEpicRequest/MakeRequest");
	xhr.send();
}