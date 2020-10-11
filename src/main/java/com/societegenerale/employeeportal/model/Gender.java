package com.societegenerale.employeeportal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gender")
public class Gender {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gender_id", nullable = false)
	private int GenderId;
	
	@Column(name = "gender_name")
	private String genderName;

	public int getGenderId() {
		return GenderId;
	}

	public void setGenderId(int genderId) {
		GenderId = genderId;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public Gender(int genderId, String genderName) {
		super();
		GenderId = genderId;
		this.genderName = genderName;
	}
	
	public Gender() {
		super();
	}

	@Override
	public String toString() {
		return "Gender [GenderId=" + GenderId + ", genderName=" + genderName + "]";
	}	

}
