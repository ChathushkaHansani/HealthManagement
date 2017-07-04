package com.chathu.petHealth.petHealth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chathu.petHealth.petHealth.model.Owner;
import com.chathu.petHealth.petHealth.repository.OwnerRepository;

@Service("ownerService")
public class ownerServiceImpl implements OwnerService {

	@Autowired
	OwnerRepository ownerRepository;

	public Owner save(Owner owner) {

		return ownerRepository.save(owner);
	}



}
