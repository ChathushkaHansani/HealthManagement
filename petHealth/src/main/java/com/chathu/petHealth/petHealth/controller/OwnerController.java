package com.chathu.petHealth.petHealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chathu.petHealth.petHealth.model.Owner;
import com.chathu.petHealth.petHealth.service.OwnerService;


@RestController
public class OwnerController {
	
	@Autowired
	OwnerService ownerService;
	

	@RequestMapping(value = "/addOwner", method = RequestMethod.POST)
	public void updateEvent(@RequestBody Owner owner) {
			ownerService.save(owner);
		
	}

}
