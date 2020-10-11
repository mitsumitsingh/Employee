package com.societegenerale.employeeportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employee_details")
public class Employee {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "e_id", nullable = false)
	private long empId;
	
	@Column(name = "e_first_name", nullable = false)
 	private String firstName;

	@Column(name = "e_last_name", nullable = false)	
 	private String lastName;
	
	@ManyToOne
	@JoinColumn(name = "e_department_id", nullable = false)	
 	private Department department;
	 
	@ManyToOne
	@JoinColumn(name = "e_gender_id", nullable = false)	
 	private Gender gender;
	 	
 	@JsonFormat(pattern="dd-mm-yyyy")
 	@Type(type="date")
 	@Temporal(TemporalType.DATE)
 	/* 
 	 * @Temporal(TemporalType.TIMESTAMP)
 	 * Used to display date with timestamp or remove @Type(type = "date") annotation it will take default.
 	 */
	@Column(name = "e_dateofbirth", nullable = false)	
    private Date dateOfBirth;
	
	@JsonProperty("departmentId")
	private void getDepartment(Integer departmentId) {
	    this.department = new Department();
	    department.setDeptId(departmentId);
	}
	
	@JsonProperty("genderId")
	private void getGender(Integer genderId) {
	    this.gender = new Gender();
	    gender.setGenderId(genderId);
	}
	

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Employee() {
		super();
	}

	public Employee(long empId, String firstName, String lastName, Department department, Gender gender,
			Date dateOfBirth) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + "]";
	} 
	
}
