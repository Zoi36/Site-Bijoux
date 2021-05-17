package com.admin.service;

import java.util.List;

import com.admin.domain.Alliance;

public interface AllianceService {

	Alliance save(Alliance allianceReady);

	Alliance save1(Alliance allianceProfil);

	List<Alliance> findAll();

	Alliance findOne(Long id);

	void removeOne(Long id);
}
