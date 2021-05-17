package com.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.domain.Alliance;
import com.admin.domain.Chain;
import com.admin.domain.Gold;
import com.admin.domain.RingSertis;
import com.admin.domain.Stone;
import com.admin.service.AllianceService;
import com.admin.service.ChainService;
import com.admin.service.GoldService;
import com.admin.service.RingSertisService;
import com.admin.service.StoneService;

@Controller
@RequestMapping("/option")
public class OptionController {

	@Autowired
	private GoldService goldService;

	@Autowired
	private ChainService chainService;

	@Autowired
	private RingSertisService ringSertisService;

	@Autowired
	private StoneService stoneService;

	@Autowired
	private AllianceService allianceService;

	@RequestMapping(value = "/addGold", method = RequestMethod.GET)
	public String addGold(Model model) {

		Gold gold = new Gold();
		model.addAttribute("gold", gold);
		return "/option/addGold";
	}

	@RequestMapping(value = "/addGold", method = RequestMethod.POST)
	public String addGoldPost(@ModelAttribute("gold") Gold gold, HttpServletRequest request) {
		goldService.save(gold);

		return "redirect:/option/goldList";

	}

	@RequestMapping("/updateGold")
	public String updateGold(@RequestParam("id") Long id, Model model) {

		Gold gold = goldService.findOne(id);
		model.addAttribute("gold", gold);

		return "/option/updateGold";
	}

	@RequestMapping(value = "/updateGold", method = RequestMethod.POST)
	public String updateGoldPost(@ModelAttribute("gold") Gold gold, HttpServletRequest request) {
		goldService.save(gold);

		return "redirect:/option/goldList";
	}

	@RequestMapping("/goldList")
	public String goldList(Model model) {
		List<Gold> goldList = goldService.findAll();
		model.addAttribute("goldList", goldList);

		return "/option/goldList";

	}

	@RequestMapping(value = "/addStone", method = RequestMethod.GET)
	public String addStone(Model model) {

		Stone stone = new Stone();
		model.addAttribute("stone", stone);
		return "/option/addStone";
	}

	@RequestMapping(value = "/addStone", method = RequestMethod.POST)
	public String addStonePost(@ModelAttribute("stone") Stone stone, HttpServletRequest request) {
		stoneService.save(stone);

		return "redirect:/option/stoneList";

	}

	@RequestMapping("/updateStone")
	public String updateStone(@RequestParam("id") Long id, Model model) {

		Stone stone = stoneService.findOne(id);
		model.addAttribute("stone", stone);

		return "/option/updateStone";
	}

	@RequestMapping(value = "/updateStone", method = RequestMethod.POST)
	public String updateStonePost(@ModelAttribute("stone") Stone stone, HttpServletRequest request) {
		stoneService.save(stone);

		return "redirect:/option/stoneList";
	}

	@RequestMapping("/stoneList")
	public String stoneList(Model model) {
		List<Stone> stoneList = stoneService.findAll();
		model.addAttribute("stoneList", stoneList);

		return "/option/stoneList";

	}

	@RequestMapping(value = "/addRingSertis", method = RequestMethod.GET)
	public String addRingSertis(Model model) {

		RingSertis ringSertis = new RingSertis();
		model.addAttribute("ringSertis", ringSertis);
		return "/option/addRingSertis";
	}

	@RequestMapping(value = "/addRingSertis", method = RequestMethod.POST)
	public String addRingSertisPost(@ModelAttribute("ringSertis") RingSertis ringSertis, HttpServletRequest request) {
		ringSertisService.save(ringSertis);

		return "redirect:/option/ringSertisList";

	}

	@RequestMapping("/updateRingSertis")
	public String updateRingSertis(@RequestParam("id") Long id, Model model) {

		RingSertis ringSertis = ringSertisService.findOne(id);
		model.addAttribute("ringSertis", ringSertis);

		return "/option/updateRingSertis";
	}

	@RequestMapping(value = "/updateRingSertis", method = RequestMethod.POST)
	public String updateRingSertisPost(@ModelAttribute("ringSertis") RingSertis ringSertis,
			HttpServletRequest request) {
		ringSertisService.save(ringSertis);

		return "redirect:/option/ringSertisList";
	}

	@RequestMapping("/ringSertisList")
	public String ringSertisList(Model model) {
		List<RingSertis> ringSertisList = ringSertisService.findAll();
		model.addAttribute("ringSertisList", ringSertisList);

		return "/option/ringSertisList";

	}

	@RequestMapping(value = "/addProfil", method = RequestMethod.GET)
	public String addProfil(Model model) {

		Alliance allianceProfil = new Alliance();
		model.addAttribute("allianceProfil", allianceProfil);
		return "/option/addProfil";
	}

	@RequestMapping(value = "/addProfil", method = RequestMethod.POST)
	public String addProfilPost(@ModelAttribute("allianceProfil") Alliance allianceProfil, HttpServletRequest request) {

		allianceService.save1(allianceProfil);

		return "redirect:/option/profilList";
	}

	@RequestMapping("/updateProfil")
	public String updateProfil(@RequestParam("id") Long id, Model model) {

		Alliance allianceProfil = allianceService.findOne(id);
		model.addAttribute("allianceProfil", allianceProfil);

		return "/option/updateProfil";
	}

	@RequestMapping(value = "/updateProfil", method = RequestMethod.POST)
	public String updateProfilPost(@ModelAttribute("allianceProfil") Alliance allianceProfil,
			HttpServletRequest request) {

		allianceService.save1(allianceProfil);

		return "redirect:/option/profilList";
	}

	@RequestMapping("/profilList")
	public String profilList(Model model) {
		List<Alliance> profilList = allianceService.findAll();
		model.addAttribute("profilList", profilList);

		return "/option/profilList";

	}

	@RequestMapping(value = "/addChain", method = RequestMethod.GET)
	public String addChain(Model model) {

		Chain chain = new Chain();
		model.addAttribute("chain", chain);
		return "/option/addChain";
	}

	@RequestMapping(value = "/addChain", method = RequestMethod.POST)
	public String addChainPost(@ModelAttribute("chain") Chain chain, HttpServletRequest request) {
		chainService.save(chain);

		return "redirect:/option/chainList";

	}

	@RequestMapping("/updateChain")
	public String updateChain(@RequestParam("id") Long id, Model model) {

		Chain chain = chainService.findOne(id);
		model.addAttribute("chain", chain);

		return "/option/updateChain";
	}

	@RequestMapping(value = "/updateChain", method = RequestMethod.POST)
	public String updateChainPost(@ModelAttribute("chain") Chain chain, HttpServletRequest request) {
		chainService.save(chain);

		return "redirect:/option/chainList";
	}

	@RequestMapping("/chainList")
	public String chainList(Model model) {
		List<Chain> chainList = chainService.findAll();
		model.addAttribute("chainList", chainList);

		return "/option/chainList";

	}

}
