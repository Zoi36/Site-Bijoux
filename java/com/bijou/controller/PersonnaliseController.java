package com.bijou.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bijou.domain.Alliance;
import com.bijou.domain.Chain;
import com.bijou.domain.Earrings;
import com.bijou.domain.Gold;
import com.bijou.domain.Necklace;
import com.bijou.domain.RingSertis;
import com.bijou.domain.RingSimple;
import com.bijou.domain.Stone;
import com.bijou.domain.User;
import com.bijou.service.AllianceService;
import com.bijou.service.ChainService;
import com.bijou.service.EarringsService;
import com.bijou.service.GoldService;
import com.bijou.service.NecklaceService;
import com.bijou.service.RingSertisService;
import com.bijou.service.RingSimpleService;
import com.bijou.service.StoneService;
import com.bijou.service.UserService;

@Controller
public class PersonnaliseController {

	@Autowired
	private RingSimpleService ringSimpleService;

	@Autowired
	private GoldService goldService;

	@Autowired
	private StoneService stoneService;

	@Autowired
	private RingSertisService ringSertisService;

	@Autowired
	private AllianceService allianceService;

	@Autowired
	private EarringsService earringsService;

	@Autowired
	private NecklaceService necklaceService;

	@Autowired
	private ChainService chainService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/ringPersonnalise", method = RequestMethod.GET)
	public String ringPersonnalise(Model model) {
		RingSimple ringSimple = new RingSimple();
		model.addAttribute("ringSimple", ringSimple);

		return "/personnalise/ringPersonnalise";
	}

	@RequestMapping(value = "/ringPersonnalise", method = RequestMethod.POST)
	public String ringPersonnalisePost(@ModelAttribute("colorGold") String colorGold,
			@ModelAttribute("qualityGold") int qualityGold, @ModelAttribute("typeStones") String typeStones,
			@ModelAttribute("typeStone") String typeStone, @ModelAttribute("haloStone") String haloStone,
			@ModelAttribute("formStone") String formStone, @ModelAttribute("weightStone") double weightStone,
			@ModelAttribute("nextStones") String nextStones, Principal principal, Model model) {

		RingSimple ringSimple = new RingSimple();

		if (!haloStone.equals("Sans") && (weightStone != 0.5)) {

				String error = "Veuillez choisir une pierre centrale de 0.5 carat!";
				model.addAttribute("error", error);

				return "personnalise/ringPersonnalise";
		}
		if (!haloStone.equals("Sans") && (!nextStones.equals("Sans"))) {

			String error2 = "Veuillez choisir soit l'option Halo soit l'option Pierres accompagnées";
			model.addAttribute("error2", error2);

			return "personnalise/ringPersonnalise";
	    }

		Gold gold = goldService.findByQualityGold(qualityGold);
		Double goldPrice = gold.getPricePerGram();
		String descriptionGold = gold.getDescription();
		gold.setDescription(descriptionGold);
		Double goldPriceRing = goldPrice * 2.0;

		RingSertis ringSertis = ringSertisService.findByTypeStones(typeStones);
		Double ringSertisPrice = ringSertis.getPrice();
		String descriptionSertis = ringSertis.getDescription();
		ringSertis.setDescription(descriptionSertis);

		Stone stone = stoneService.findByTypeStoneAndHaloStoneAndWeightStoneAndNextStones(typeStone, haloStone,
				weightStone, nextStones);
		
		Double stonePrice = stone.getPrice();
		Double ringSimplePrice = goldPriceRing + ringSertisPrice + stonePrice;
		
		stone.setFormStone(formStone);
		gold.setColorGold(colorGold);
		ringSimple.setGold(gold);
		ringSimple.setWeightMetal(2.0);
		ringSimple.setRingSertis(ringSertis);
		ringSimple.setStone(stone);
		ringSimple.setPrice(ringSimplePrice);

		ringSimpleService.save(ringSimple);
		model.addAttribute("ringSimple", ringSimple);

		return "forward:/ringSimplePresentation?id=" + ringSimple.getId();

	}

	@RequestMapping("/ringSimplePresentation")
	public String ringSimplePresentation(@RequestParam("id") Long id, Model model, Principal principal) {

		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		RingSimple ringSimple = ringSimpleService.findOne(id);

		model.addAttribute("ringSimple", ringSimple);

		return "/personnalise/ringSimplePresentation";
	}

	@RequestMapping(value = "/alliancePersonnalise", method = RequestMethod.GET)
	public String alliancePersonnalise(Model model) {
		Alliance alliance = new Alliance();
		model.addAttribute("alliance", alliance);

		return "/personnalise/alliancePersonnalise";
	}

	@RequestMapping(value = "/alliancePersonnalise", method = RequestMethod.POST)
	public String allianceCreatePost(@ModelAttribute("colorGold") String colorGold,
			@ModelAttribute("qualityGold") int qualityGold, @ModelAttribute("typeFinish") String typeFinish,
			@ModelAttribute("profilAlliance") String profilAlliance, @ModelAttribute("widthAlliance") int widthAlliance,
			@ModelAttribute("textEngraving") String textEngraving,
			@ModelAttribute("fontEngraving") String fontEngraving, Principal principal, Model model) {

		Gold gold = goldService.findByQualityGold(qualityGold);
		Double goldPrice = gold.getPricePerGram();
		String descriptionGold = gold.getDescription();

		List<Alliance> allianceOld = allianceService.findByProfilAllianceAndWidthAlliance(profilAlliance,
				widthAlliance);

		Double profilPrice = allianceOld.get(0).getPrice();
		Double weightGold = allianceOld.get(0).getWeightMetal();
		String descriptionProfil = allianceOld.get(0).getDescription();
		Double alliancePrice = (goldPrice * weightGold) + profilPrice;
		String profil = allianceOld.get(0).getProfilAlliance();
		int width = allianceOld.get(0).getWidthAlliance();

		Alliance alliance = allianceService.createAlliance(gold, colorGold, qualityGold, typeFinish, profil, width,
				textEngraving, fontEngraving, descriptionGold, descriptionProfil, weightGold, alliancePrice);

		model.addAttribute("alliance", alliance);

		return "forward:/alliancePresentation?id=" + alliance.getId();

	}

	@RequestMapping("/alliancePresentation")
	public String alliancePresentation(@RequestParam("id") Long id, Model model, Principal principal) {

		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		Alliance alliance = allianceService.findOne(id);

		model.addAttribute("alliance", alliance);

		return "/personnalise/alliancePresentation";
	}

	@RequestMapping(value = "/earringsPersonnalise", method = RequestMethod.GET)
	public String earringsPersonnalise(Model model) {
		Earrings earrings = new Earrings();
		model.addAttribute("earrings", earrings);

		return "/personnalise/earringsPersonnalise";
	}

	@RequestMapping(value = "/earringsPersonnalise", method = RequestMethod.POST)
	public String earringsPersonnalisePost(@ModelAttribute("colorGold") String colorGold,
			@ModelAttribute("qualityGold") int qualityGold, @ModelAttribute("typeStone") String typeStone,
			@ModelAttribute("haloStone") String haloStone, @ModelAttribute("formStone") String formStone,
			Principal principal, Model model) {

		Earrings earrings = new Earrings();

		Gold gold = goldService.findByQualityGold(qualityGold);
		Double goldPrice = gold.getPricePerGram();
		String descriptionGold = gold.getDescription();
		gold.setDescription(descriptionGold);
		Double goldPriceEarrings = goldPrice * 1.0;

		double weightStone = 0.5;
		String nextStones = "Sans";

		Stone stone = stoneService.findByTypeStoneAndHaloStoneAndWeightStoneAndNextStones(typeStone, haloStone,
				weightStone, nextStones);

		Double stonePrice = stone.getPrice();
		Double earringsPrice = goldPriceEarrings + stonePrice;

		stone.setFormStone(formStone);
		gold.setColorGold(colorGold);
		earrings.setGold(gold);
		earrings.setWeightMetal(1.0);
		earrings.setStone(stone);
		earrings.setPrice(earringsPrice);

		earringsService.save(earrings);

		model.addAttribute("earrings", earrings);

		return "forward:/earringsPresentation?id=" + earrings.getId();

	}

	@RequestMapping("/earringsPresentation")
	public String earringsPresentation(@RequestParam("id") Long id, Model model, Principal principal) {

		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		Earrings earrings = earringsService.findOne(id);

		model.addAttribute("earrings", earrings);

		return "/personnalise/earringsPresentation";
	}

	@RequestMapping(value = "/necklacePersonnalise", method = RequestMethod.GET)
	public String necklacePersonnalise(Model model) {
		Necklace necklace = new Necklace();
		model.addAttribute("necklace", necklace);

		return "/personnalise/necklacePersonnalise";
	}

	@RequestMapping(value = "/necklacePersonnalise", method = RequestMethod.POST)
	public String necklacePersonnalisePost(@ModelAttribute("colorGold") String colorGold,
			@ModelAttribute("qualityGold") int qualityGold, @ModelAttribute("typeStone") String typeStone,
			@ModelAttribute("haloStone") String haloStone, @ModelAttribute("formStone") String formStone,
			@ModelAttribute("typeChain") String typeChain, Principal principal, Model model) {

		Necklace necklace = new Necklace();

		Gold gold = goldService.findByQualityGold(qualityGold);
		Double goldPrice = gold.getPricePerGram();
		String descriptionGold = gold.getDescription();
		gold.setDescription(descriptionGold);
		Double goldPriceNecklace = goldPrice * 1.0;

		double weightStone = 0.5;
		String nextStones = "Sans";

		Stone stone = stoneService.findByTypeStoneAndHaloStoneAndWeightStoneAndNextStones(typeStone, haloStone,
				weightStone, nextStones);

		Chain chain = chainService.findByTypeChain(typeChain);
		String descriptionChain = chain.getDescription();

		Double chainPrice = chain.getPrice();

		Double stonePrice = stone.getPrice();
		Double necklacePrice = goldPriceNecklace + stonePrice + chainPrice;

		stone.setFormStone(formStone);
		gold.setColorGold(colorGold);
		necklace.setGold(gold);
		necklace.setWeightMetal(1.0);
		necklace.setStone(stone);
		chain.setTypeChain(typeChain);
		chain.setDescription(descriptionChain);
		necklace.setChain(chain);
		necklace.setPrice(necklacePrice);

		necklaceService.save(necklace);

		model.addAttribute("necklace", necklace);

		return "forward:/necklacePresentation?id=" + necklace.getId();

	}

	@RequestMapping("/necklacePresentation")
	public String necklacePresentation(@RequestParam("id") Long id, Model model, Principal principal) {

		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		Necklace necklace = necklaceService.findOne(id);

		model.addAttribute("necklace", necklace);

		return "/personnalise/necklacePresentation";
	}

}
