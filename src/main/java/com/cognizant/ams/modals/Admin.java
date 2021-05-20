package com.cognizant.ams.modals;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@Column(name = "admin_Id", length = 10)
	private int adminId;

	@Size(min=8,max=15,message="Min 5 chars requed")
	@Column(name = "password", length = 15)
	private String password;

}
