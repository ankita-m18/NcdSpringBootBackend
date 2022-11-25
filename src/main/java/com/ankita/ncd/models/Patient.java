package com.ankita.ncd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_info")
public class Patient 
{
	@Id
	@Column(name="sl_no",nullable = false )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	
	@Column(name="patient_id",nullable = false )
	private String patientid=String.valueOf((long)(Math.random()*(99999999999999L-10000000000000L+1)+10000000000000L));
	
	@Column(name="first_name",nullable = true, length=50)
	private String firstname;
	
	@Column(name="last_name",nullable = true, length=50)
	private String lastname;
	
	@Column(name="gender",nullable = true, length=10)
	private String gender;
	
	@Column(name="phone_no",nullable = true, length=10)
	private String phone;
	
	@Column(name="dob",nullable = true, length=15)
	private String birthday;
	
	@Column(name="pincode",nullable = true)
	private int pincode;
	
	@Column(name="score",nullable = true)
	private int score;
	
	@Column(name="screening",nullable = true, length=5)
	private String screening;
	


	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getScreening() {
		return screening;
	}

	public void setScreening(String screening) {
		this.screening = screening;
	}
	
	

}
