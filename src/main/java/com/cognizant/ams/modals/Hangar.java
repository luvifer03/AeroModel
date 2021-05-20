package com.cognizant.ams.modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Hangar")
public class Hangar {

	@Id
	@Column(name = "hangarId", length = 10)
	@GeneratedValue
	private int hangarId;

	@Column(name = "managerId", length = 10)
	private int managerId;

	@Column(name = "planeId", length = 10)
	private int planeId;

	@NotEmpty(message = "please enter the city")
	@Column(name = "city", length = 50)
	private String city;

	public Hangar() {

	}

	public Hangar(int hangarId, int managerId, int planeId, String city) {
		super();
		this.hangarId = hangarId;
		this.managerId = managerId;
		this.planeId = planeId;
		this.city = city;

	}

	public int getPlaneId() {
		return planeId;
	}

	public void setPlaneId(int planeId) {
		this.planeId = planeId;
	}

	public int getHangarId() {
		return hangarId;
	}

	public void setHangarId(int hangarId) {
		this.hangarId = hangarId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
