package com.revature.model;




public class DBEmployees{

	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private int mobile;
	private String address;
	private String city;
	private String state;
	private String countryCode;
	private int salary;
	private int positionId;
	
	
	
	public DBEmployees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DBEmployees(int employeetId, String firstName, String lastName, String email, int mobile, String address,
			String city, String state, String countryCode, int salary, int positionId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.city = city;
		this.state = state;
		this.countryCode = countryCode;
		this.salary = salary;
		this.positionId = positionId;
		
	}

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeetId) {
		this.employeeId = employeetId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	@Override
	public String toString() {
		return "DBEmployees [employeetId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", mobile=" + mobile + ", address=" + address + ", city=" + city + ", state="
				+ state + ", countryCode=" + countryCode + ", salary=" + salary + ", positionId=" + positionId + "]";
	}
	

	
	
	
}

