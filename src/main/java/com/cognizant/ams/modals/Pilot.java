package com.cognizant.ams.modals;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "Pilot")
public class Pilot {

	//@NotEmpty(message = "firstName cannot be empty")
	@Column(name = "firstName", length = 50)
	private String firstName;
	
	//@NotEmpty(message = "lastName cannot be empty")
	@Column(name = "lastName", length = 50)
	private String lastName;
	
	@Id
	//@NotEmpty(message = "PilotId cannot be empty")
	@GeneratedValue
	@Column(name = "pilot_id", length = 10)
	private int pilotId;
	

	//@NotEmpty(message = "gender cannot be empty")
	@Column(name = "gender", length = 10)
	private String gender;
	
	//@NotEmpty(message = "please enter the dob")
	@Column(name = "dob", length = 10)
	private String dob;
	
	//@NotEmpty(message = "Contact Number cannot be empty")
	@Column(name = "contactNumber", length = 10)
	private String contactNumber;
	
	@Size(min = 6, message = "Password atleast have 6 characters")
	@Column(name = "password", length = 15)
	private String password;

	public Pilot() {
		super();
		
	}

	public Pilot(@NotEmpty(message = "firstName cannot be empty") String firstName,
			@NotEmpty(message = "lastName cannot be empty") String lastName,
			@NotEmpty(message = "Pilot id cannot be empty") int pilotId,
			@NotEmpty(message = "gender cannot be empty") String gender,
			@NotEmpty(message = "please enter the dob") String dob,
			@NotEmpty(message = "Contact Number cannot be empty") String contactNumber,
		
			@Size(min = 5, message = "Min 5 chars required") String password) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.pilotId = pilotId;
		this.gender = gender;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.password = password;
	}

	
	public int getPilotId() {
		return pilotId;
	}

	public void SetPilotId(int pilotId) {
		this.pilotId = pilotId;
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
