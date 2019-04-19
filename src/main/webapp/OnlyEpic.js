window.onload = () => {
	document.getElementById("fetch").addEventListener("click", getAllReimbursements);
}

function backTo(){
	document.location.replace("../index.html");
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

const populateReimbursementsTable = (listOfDBReimbursments) =>{
	for(let Reimbursments of listOfDBReimbursments){
		const tdId = document.createElement("td");
		const tdType = document.createElement("td");
		const tdAmount = document.createElement("td");
		const tdReason = document.createElement("td");
		const tdSubmittedBy = document.createElement("td");
		const tdStatus = document.createElement("td");
		
		tdId.textContent = Reimbursments.reimbursmentId;
		tdType.textContent = Reimbursments.reimbursmentType;
		tdAmount.textContent = Reimbursments.amount;
		tdReason.textContent = Reimbursments.reason;
		tdSubmittedBy.textContent = Reimbursments.employeeId;
		tdStatus.textContent = Reimbursments.status;
		
		const row = document.createElement("tr");
		row.appendChild(tdId);
		row.appendChild(tdType);
		row.appendChild(tdAmount);
		row.appendChild(tdReason);
		row.appendChild(tdSubmittedBy);
		row.appendChild(tdStatus);
		
		document.getElementById("ReimbursementsTable").appendChild(row);
	}
}

