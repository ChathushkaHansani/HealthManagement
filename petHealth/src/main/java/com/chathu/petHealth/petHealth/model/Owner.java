package com.chathu.petHealth.petHealth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OWNER")
public class Owner {
	
	@Id
	@GeneratedValue
	@Column(name="ownerId")
	private Long id;
	
	@Column(name="ownerName")
	private String ownerName;

	private String ownerCity;
	private String ownerMobile;
	
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerCity() {
		return ownerCity;
	}
	public void setOwnerCity(String ownerCity) {
		this.ownerCity = ownerCity;
	}
	public String getOwnerMobile() {
		return ownerMobile;
	}
	public void setOwnerMobile(String ownerMobile) {
		this.ownerMobile = ownerMobile;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	
	
	
}
