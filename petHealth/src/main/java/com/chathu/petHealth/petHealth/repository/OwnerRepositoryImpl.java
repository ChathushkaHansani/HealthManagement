package com.chathu.petHealth.petHealth.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.chathu.petHealth.petHealth.model.Owner;
import org.springframework.transaction.annotation.Transactional;

@Repository("ownerRepository")
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

	public List<Owner> viewAll(){
		Query query= entityManager.createQuery("select e from Owner e");
		List<Owner> owners= query.getResultList();

		/*for(Owner owner: owners){
			System.out.println(owner);
		}*/
		return owners;
	}


}
