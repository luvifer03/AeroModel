package com.cognizant.ams.modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "HangarStatus")
public class HangarStatus {

	@Id
	@Column(name = "hangarId", length = 10)
	
	private int hangarId;
	
	@Column(name = "managerId", length = 10)
	@NotEmpty(message="please enter Manager Id")
	private int managerId;
	
	@NotEmpty(message="please select the status of the hangar")
	@Column(name = "status")
	private String status;
	
   
	public HangarStatus() {
		super();
		
	}

	public HangarStatus(int hangarId, int managerId, String status) {
		super();
		this.hangarId = hangarId;
		this.managerId = managerId;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
