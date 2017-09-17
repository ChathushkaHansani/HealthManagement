package com.chathu.petHealth.petHealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.chathu.petHealth.petHealth.model.Owner;
import com.chathu.petHealth.petHealth.service.OwnerService;


@RestController

public class OwnerController {
	
	@Autowired
	OwnerService ownerService;
	

	@RequestMapping(value = "/addOwner", method = RequestMethod.POST)
	@CrossOrigin
	public void updateEvent(@RequestBody Owner owner) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(owner.getPetData().size());
			ownerService.save(owner);
		
	}

	@RequestMapping(value = "/viewOwner", method = RequestMethod.GET)
	@CrossOrigin
	public List<Owner> viewOwner(){
		return ownerService.viewAll();
	}

}
