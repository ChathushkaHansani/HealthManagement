package com.chathu.petHealth.petHealth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chathu.petHealth.petHealth.model.Owner;
import com.chathu.petHealth.petHealth.repository.OwnerRepository;
import org.springframework.transaction.annotation.Transactional;

@Service("ownerService")
@Transactional
public class ownerServiceImpl implements OwnerService {

	@Autowired
	OwnerRepository ownerRepository;

	public Owner save(Owner owner) {
		return ownerRepository.save(owner);
	}

	public List<Owner> viewAll(){
		return  ownerRepository.viewAll();
	}

}
