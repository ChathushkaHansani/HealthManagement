package com.chathu.petHealth.petHealth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="OWNER")

public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="ownerName")
	private String ownerName;

	@Column(name="ownerCity")
	private String ownerCity;

	@Column(name="ownerMobile")
	private String ownerMobile;

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "id")
	private List<Pet> petData = new ArrayList<Pet>();

	public List<Pet> getPetData() {
		return petData;
	}


	public void setPetData(List<Pet> petData) {
		for(Pet pet:petData){
			pet.setOwner(this);
		}

		this.petData = petData;
	}

	public String toString(){

		/*return "{\"name\":" + getOwnerName() + ",\"mobile\":" + getOwnerCity() + ",\"City\":" + getOwnerMobile() + "}";*/
		return getOwnerName() +  getOwnerCity()  + getOwnerMobile();
}

	/*
	public List<Pet> getPetData() {
		return petData;
	}

	public void setPetData(List<Pet> petData) {
		this.petData = petData;
	}
*/

	
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
