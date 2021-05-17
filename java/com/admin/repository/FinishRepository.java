package com.admin.repository;

import org.springframework.data.repository.CrudRepository;

import com.admin.domain.Finish;


public interface FinishRepository extends CrudRepository<Finish, Long>{
	
	
 
	Finish findByTypeFinish(String typeFinish);
}
