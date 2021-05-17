package com.bijou.repository;

import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.Finish;


public interface FinishRepository extends CrudRepository<Finish, Long>{
	
	
 
	Finish findByTypeFinish(String typeFinish);
}
