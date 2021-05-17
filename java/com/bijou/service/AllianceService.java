package com.bijou.service;

import java.util.List;

import com.bijou.domain.Alliance;
import com.bijou.domain.Gold;

public interface AllianceService {

	List<Alliance> findByProfilAllianceAndWidthAlliance(String profilAlliance, int widthAlliance);

	Alliance createAlliance(Gold gold, String colorGold, int qualityGold, String typeFinish, String profil, int width,
			String textEngraving, String fontEngraving, String descriptionGold, String descriptionProfil,
			double weightGold, double alliancePrice);

	List<Alliance> findAll();

	Alliance findOne(Long id);
}
