window.onload = () => {
	document.getElementById("Submit").addEventListener("click", createReimbursment);
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
	xhr.open("POST", "http://localhost:8088/OnlyEpicRequest/api/reimbursments");
	xhr.send(JSON.stringify(formData));
}

const parseForm = () => {
	const reimbursmentTypeText = document.getElementById("reimbursmentType");
	const amountText = document.getElementById("amount");
	const employeeIdText = document.getElementById("employeeId");
	return{
		reimbursment: reimbursmentTypeText,
		amount: amountText,
		employeeId: employeeIdText,
	}

}
