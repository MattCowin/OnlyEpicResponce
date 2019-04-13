package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
//DO
public class DBEmployees implements Serializable {

	@Id 
	@Column(name="EMPLOYEE_ID", precision=4, scale=0)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeetId;
	@Column(name="FIRST_NAME", length=20)
	private String firstName;
	@Column(name="LAST_NAME", length=25)
	private String lastName;
	@Column(name="EMAIL", length=100, nullable=false)
	private String email;
	@Column(name="MOBILE", length=10, nullable=false)
	private int mobile;
	@Column(name="ADDRESS", length=100)
	private String address;
	@Column(name="CITY", length=50)
	private String city;
	@Column(name="STATE", length=2)
	private String state;
	@Column(name="COUNTRY_CODE", length=20)
	private String countryCode;
	@Column(name="SALARY", length=6)
	private int salary;
	@Column(name="POSITION_ID")
	private int positionId;
	@Column(name="MANAGER_ID", length=4)
	private int managerId;
	
	
	public DBEmployees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DBEmployees(int employeetId, String firstName, String lastName, String email, int mobile, String address,
			String city, String state, String countryCode, int salary, int positionId, int managerId) {
		super();
		this.employeetId = employeetId;
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
		this.managerId = managerId;
	}

	public int getEmployeetId() {
		return employeetId;
	}
	public void setEmployeetId(int employeetId) {
		this.employeetId = employeetId;
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
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "DBEmployees [employeetId=" + employeetId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", mobile=" + mobile + ", address=" + address + ", city=" + city + ", state="
				+ state + ", countryCode=" + countryCode + ", salary=" + salary + ", positionId=" + positionId
				+ ", managerId=" + managerId + "]";
	}
	
	
}

