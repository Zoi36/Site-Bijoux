package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.repository.AllianceRepository;
import com.admin.service.AllianceService;
import com.admin.domain.Alliance;

@Service
public class AllianceServiceImpl implements AllianceService {

	@Autowired
	private AllianceRepository allianceRepository;

	public Alliance save(Alliance allianceReady) {
		return allianceRepository.save(allianceReady);
	}

	public Alliance save1(Alliance allianceProfil) {
		return allianceRepository.save(allianceProfil);
	}

	public List<Alliance> findAll() {
		return (List<Alliance>) allianceRepository.findAll();
	}

	public Alliance findOne(Long id) {
		return allianceRepository.findOne(id);
	}

	public void removeOne(Long id) {
		allianceRepository.delete(id);
	}
}
