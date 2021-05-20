package com.cognizant.ams.modals;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Plane")
public class Plane {


	@Id
	@Column(name = "planeId", length = 10)
	//@NotNull(message="Model cannot be empty");
	private int planeId;
	
	@Column(name = "modelNumber", length = 10)
	/* @NotNull(message="Model cannot be empty") */
	private int modelNumber;
    
	@Column(name = "purchaseDate")
	/* @NotEmpty(message="Purchase date is required") */
	private String purchaseDate;
    
	@Column(name = "lastServiceDate")
	/* @NotNull(message="Model cannot be empty") */
    private String lastServiceDate;

	public int getPlaneId() {
		return planeId;
	}

	public void setPlaneId(int planeId) {
		this.planeId = planeId;
	}

	public int getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	public Plane(int planeId, @NotNull(message = "Model cannot be empty") int modelNumber,
			@NotEmpty(message = "Purchase date is required") String purchaseDate,
			@NotNull(message = "Model cannot be empty") String lastServiceDate) {
		super();
		this.planeId = planeId;
		this.modelNumber = modelNumber;
		this.purchaseDate = purchaseDate;
		this.lastServiceDate = lastServiceDate;
	}

	@Override
	public String toString() {
		return "Plane [planeId=" + planeId + ", modelNumber=" + modelNumber + ", purchaseDate=" + purchaseDate
				+ ", lastServiceDate=" + lastServiceDate + "]";
	}

	public Plane() {
		super();
	}
    
    
	
}
