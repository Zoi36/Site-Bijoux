package com.bijou.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bijou.domain.Alliance;

public interface AllianceRepository extends CrudRepository<Alliance, Long> {


	List<Alliance> findByProfilAllianceAndWidthAlliance(String profilAlliance, int widthAlliance);

}
