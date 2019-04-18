window.onload = () => {
	getAllReimbursements();
}
//function get(url){
//	return new Promise((resolve, reject) =>{
//		let xhr =new XMLHttpRequest();
//		
//		xhr.onreadystatechange = function(){
//			if(xhr.readyState == 4 && xhr.status == 200){
//				resolve(JSON.parse(xhr.response));
//			}
//			else{
//				reject(Error("Oops. Something went wrong."));
//			}
//		}
//		
//		
//		
//		
//		xhr.open("GET", url);
//		xhr.send();
//	}
//	)
//}
////Need this function to populate the reimbursments form
//function getReimbursmentRequest(){
//	let url = "../reimbursments.html";
//	
//	let selectBox = document.getElementById("selectBox");
//	let results = get(url).then(data => {
//		console.log(data);
//		//enhanced for loop in JavaScript
//		for(let d in data){
//			let option = document.createElement("option");
//			option.innerHTML = data[d]["name"];
//			option.value = data[d]["id"];
//			selectBox.append(option);
//		}
//	}).catch(error =>{
//		console.lot("Hey, where's my data?")
//	});
//}

function backTo(){
	document.location.replace("../index.html");
}

function submit(){
	
}

const populateReimbursementsTable = (listOfDBReimbursments) =>{
	for(let Reimbursments of listOfDBReimbursments){
		const tdId = document.createElement("td");
		const tdType = document.createElement("td");
		const tdAmount = document.createElement("td");
		const tdReason = document.createElement("td");
		const tdSubmittedBy = document.createElement("td");
		const tdApprovedBy = document.createElement("td");
		const tdStatus = document.createElement("td");
		
		tdId.textContent = DBReimbursments.reimbursmentId;
		tdType.textContent = DBReimbursments.reimbursmentType;
		tdAmount.textContent = DBReimbursments.amount;
		tdReason.textContent = DBReimbursments.reason;
		tdSubmittedBy.textContent = DBReimbursments.employeeId;
		tdApprovedBy.textContent = DBReimbursments.approvedBy;
		tdStatus.textContent = DBReimbursments.status;
		
		const row = document.createElement("tr");
		row.appendChild(tdId);
		row.appendChild(tdType);
		row.appendChild(tdAmount);
		row.appendChild(tdReason);
		row.appendChild(tdSubmittedBy);
		row.appendChild(tdApprovedBy);
		row.appendChild(tdStatus);
		
		document.getElementById("ertable").appendChild(row);
	}
}

const getAllReimbursements = () => {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () =>{
		if(xhr.status === 200 && xhr.readyState === 4){
			populateReimbursementsTable(JSON.parse(json));
		}
	};
	xhr.open("GET", "./MakeRequest");
	xhr.send();
}
