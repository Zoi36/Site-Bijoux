package com.bijou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bijou.domain.Alliance;
import com.bijou.domain.Engraving;
import com.bijou.domain.Finish;
import com.bijou.domain.Gold;
import com.bijou.repository.AllianceRepository;
import com.bijou.service.AllianceService;

@Service
public class AllianceServiceImpl implements AllianceService {

	@Autowired
	private AllianceRepository allianceRepository;

	public List<Alliance> findByProfilAllianceAndWidthAlliance(String profilAlliance, int widthAlliance) {

		return (List<Alliance>) allianceRepository.findByProfilAllianceAndWidthAlliance(profilAlliance, widthAlliance);
	}

	public List<Alliance> findAll() {
		List<Alliance> allianceReadyList = (List<Alliance>) allianceRepository.findAll();

		return allianceReadyList;
	}

	public Alliance findOne(Long id) {
		return allianceRepository.findOne(id);
	}

	public synchronized Alliance createAlliance(Gold gold, String colorGold, int qualityGold, String typeFinish,
			String profil, int width, String textEngraving, String fontEngraving, String descriptionGold,
			String descriptionProfil, double weightGold, double alliancePrice) {

		Alliance alliance = new Alliance();
		Engraving engraving = new Engraving();
		Finish finish = new Finish();

		finish.setTypeFinish(typeFinish);
		alliance.setFinish(finish);
		alliance.setFinish(finish);

		gold.setColorGold(colorGold);
		gold.setQualityGold(qualityGold);
		gold.setDescription(descriptionGold);
		alliance.setGold(gold);

		alliance.setWidthAlliance(width);

		engraving.setFontEngraving(fontEngraving);
		engraving.setTextEngraving(textEngraving);
		alliance.setEngraving(engraving);

		alliance.setWeightMetal(weightGold);

		alliance.setDescription(descriptionProfil);
		alliance.setProfilAlliance(profil);

		alliance.setPrice(alliancePrice);

		alliance = allianceRepository.save(alliance);

		return alliance;
	}
}
