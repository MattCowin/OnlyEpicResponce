window.onload = () => {
	document.getElementById("SubmitRequest").addEventListener("click", updateInfo);
}

const updateInfo = () => {
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
	document.getElementById("updated").innerHTML("Information Updated");
	
}

const parseForm = () => {
	const emailText = document.getElementById("Email");
	const mobileText = document.getElementById("MOBILE");
	const addressText = document.getElementById("ADDRESS");
	const cityText = document.getElementById("CITY");
	const stateText = document.getElementById("STATE");
	const zipText = document.getElementById("ZIP");
	
	return{
		email: emailText,
		mobile: mobileText,
		address: addressText,
		city: cityText,
		state: stateText,
		zip: zipText
	}

}
