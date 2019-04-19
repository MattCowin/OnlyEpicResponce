window.onload = () => {
	document.getElementById("SubmitRequest").addEventListener("click", createReimbursment);
}

const createReimbursment = () => {
	const xhr = new XMLHttpRequest();
	const forData = parseForm();
	xhr.onreadystatechange = () => {
		if(xhr.status === 200 && xhr.readyState === 4){
			const json = xhr.responseText;
			console.log(json);
		}
	}
	xhr.open("POST", "http://localhost:8088/OnlyEpicRequest/reimbursments");
	xhr.send(JSON.stringify(formData));
	document.getElementById("Submitted").innerHTML("Reimbursement Submitted");
	document.getElementById("Submitted").style.color("Green");
}

const parseForm = () => {
	const reimbursmentTypeText = document.getElementById("reimbursmentType");
	const amountText = document.getElementById("amount");
	const reasonText = document.getElementById("reason");
	const employeeIdText = document.getElementById("employeeId");
	return{
		reimbursment: reimbursmentTypeText,
		amount: amountText,
		reason: reasonText,
		employeeId: employeeIdText,
		status: "Pending"
	}

}


