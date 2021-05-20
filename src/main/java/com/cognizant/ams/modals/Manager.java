package com.cognizant.ams.modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Manager")
public class Manager {
	@SequenceGenerator(name = "manaSeq",initialValue = 100, allocationSize = 1, sequenceName = "MANA_SEQ")
	/* @NotEmpty(message = "firstName cannot be empty") */
	@Column(name = "firstName", length = 50)
	private String firstName;
	
	/* @NotEmpty(message = "lastName cannot be empty") */
	@Column(name = "lastName", length = 50)
	private String lastName;
	
	@Id
	@Column(name = "managerId", length = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manaSeq")
	private int managerId;
	

	/* @NotEmpty(message = "gender cannot be empty") */
	@Column(name = "gender", length = 10)
	private String gender;
	
	/* @NotEmpty(message = "please enter the dob") */
	@Column(name = "dob", length = 10)
	private String dob;
	
	@NotEmpty(message = "Contact Number cannot be empty")
	@Column(name = "contactNumber", length = 10)
	private String contactNumber;
	
	/* @Size(min = 6, message = "Password atleast have 6 characters") */
	@Column(name = "password", length = 15)
	private String password;
	
	@Column 
	private String status;
	

	public Manager() {
		super();
		
	}

	public Manager(@NotEmpty(message = "First name cannot be empty") String firstName,
			@NotEmpty(message = "lastName cannot be empty") String lastName,
			@NotEmpty(message = "Manager id cannot be empty") int managerId,
			@NotEmpty(message = "gender cannot be empty") String gender,
			@NotEmpty(message = "please enter the dob") String dob,
			@NotEmpty(message = "Contact Number cannot be empty") String contactNumber,
			
			@Size(min = 5, message = "Min 5 chars required") String password) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.managerId = managerId;
		this.gender = gender;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.password = password;
	}

	
	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
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



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
