package com.chathu.petHealth.petHealth.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.chathu.petHealth.petHealth.model.Owner;
import org.springframework.transaction.annotation.Transactional;

@Repository("ownerRepository")
@Transactional
public class OwnerRepositoryImpl implements OwnerRepository{
	
	@PersistenceContext
	EntityManager entityManager;

	public Owner save(Owner owner) {
		System.out.println(owner.getId() + owner.getOwnerName());
		
		if(owner.getId()==null){
			entityManager.persist(owner);
		}else{
			owner = entityManager.merge(owner);
		}
		entityManager.flush();
		return owner;
	}



}
