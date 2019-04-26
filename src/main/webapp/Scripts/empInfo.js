window.onload = () => {
	console.log("loaded");
	getEmployeeByUsername();
}

const getEmployeeByUsername = () => {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () =>{
		if(xhr.status === 200 && xhr.readyState === 4){
			
			let json = JSON.parse(xhr.responseText);
			console.log(json);
			populateEmployeeInfo(json);
		}
	};
	xhr.open("GET", "http://localhost:8088/OnlyEpicRequest/GetEmployeeInfo");
	xhr.send();
}
function populateEmployeeInfo(emp){

	const tdId = document.createElement("h2");
	const tdFirstName = document.createElement("h2");
	const tdLastName = document.createElement("h2");
	const tdEmail = document.createElement("h2");
	const tdMobile = document.createElement("h2");
	const tdAddress = document.createElement("h2");
	const tdCity = document.createElement("h2");
	const tdState = document.createElement("h2");
	const tdCountryCode = document.createElement("h2");
	const tdSalary = document.createElement("h2");
	
	
	tdId.textContent = emp.employeeId;
	tdFirstName.textContent = emp.firstName;
	tdLastName.textContent = emp.lastName;
	tdEmail.textContent = emp.email;
	tdMobile.textContent = emp.mobile;
	tdAddress.textContent = emp.address;
	tdCity.textContent = emp.city;
	tdState.textContent = emp.state;
	tdCountryCode.textContent = emp.countryCode;
	tdSalary.textContent = emp.salary;
	
	
//	const row = document.createElement("tr");
//	row.appendChild(tdId);
//	row.appendChild(tdType);
//	row.appendChild(tdAmount);
//	row.appendChild(tdReason);
//	row.appendChild(tdSubmittedBy);
//	row.appendChild(tdStatus);
//	row.appendChild(approve);
//	row.appendChild(deny);
//	document.getElementById("ReimbursementsTable").appendChild(row);
//	

}