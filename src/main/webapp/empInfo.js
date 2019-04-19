window.onload = () => {
	getAllReimbursements();
}

function backTo(){
	document.location.replace("../index.html");
}


const getEmpInfo = () => {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () =>{
		if(xhr.status === 200 && xhr.readyState === 4){
			
			let json = JSON.parse(xhr.responseText);
			console.log(json);
			populateReimbursementsTable(json);
		}
	};
	xhr.open("GET", "http://localhost:8088/OnlyEpicRequest/GetEmployeeInfo");
	xhr.send();
}

const populateEmpInfo = () =>{
	for(let Reimbursments of listOfDBReimbursments){
		const employeeId = document.createElement("td");
		const firstName = document.createElement("td");
		const lastName = document.createElement("td");
		const lastName = document.createElement("td");
		const email = document.createElement("td");
		const mobile = document.createElement("td");
		const address = document.createElement("td");
		const city = document.createElement("td");
		const state = document.createElement("td");
		const countryCode = document.createElement("td");
		const salary = document.createElement("td");
		
		
		
		tdId.textContent = EmpInfo.employeeId;
		tdType.textContent = EmpInfo.firstName;
		tdAmount.textContent = EmpInfo.lastName;
		tdReason.textContent = EmpInfo.email;
		tdSubmittedBy.textContent = EmpInfo.mobile;
		tdStatus.textContent = EmpInfo.address;
		tdType.textContent = EmpInfo.city;
		tdAmount.textContent = EmpInfo.state;
		tdReason.textContent = EmpInfo.countryCode;
		tdSubmittedBy.textContent = EmpInfo.salary;
		
		
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