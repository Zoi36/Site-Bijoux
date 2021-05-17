package com.admin.service;

import java.util.List;
import com.admin.domain.Necklace;

public interface NecklaceService {

	Necklace save(Necklace necklaceReady);

	List<Necklace> findAll();

	Necklace findOne(Long id);

	void removeOne(Long id);
}
