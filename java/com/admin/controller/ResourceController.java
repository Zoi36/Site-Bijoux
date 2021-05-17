package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.admin.service.AllianceService;
import com.admin.service.EarringsService;
import com.admin.service.NecklaceService;
import com.admin.service.RingSimpleService;

@RestController
public class ResourceController {

	@Autowired
	private RingSimpleService ringSimpleService;

	@Autowired
	private AllianceService allianceService;

	@Autowired
	private EarringsService earringsService;

	@Autowired
	private NecklaceService necklaceService;

	@RequestMapping(value = "/ready/removeRingSimpleReadyList", method = RequestMethod.POST)
	public String removeRingSimpleReadyList(@RequestBody List<String> ringSimpleReadyIdList, Model model) {

		for (String id : ringSimpleReadyIdList) {
			String ringSimpleReadyId = id.substring(8);
			ringSimpleService.removeOne(Long.parseLong(ringSimpleReadyId));
		}

		return "supprimer avec success";
	}

	@RequestMapping(value = "/ready/removeAllianceReadyList", method = RequestMethod.POST)
	public String removeAllianceReadyList(@RequestBody List<String> allianceReadyIdList, Model model) {

		for (String id : allianceReadyIdList) {
			String allianceReadyId = id.substring(8);
			allianceService.removeOne(Long.parseLong(allianceReadyId));
		}

		return "supprimer avec success";
	}

	@RequestMapping(value = "/ready/removeEarringsReadyList", method = RequestMethod.POST)
	public String removeEarringsReadyList(@RequestBody List<String> earringsReadyIdList, Model model) {

		for (String id : earringsReadyIdList) {
			String earringsReadyId = id.substring(8);
			earringsService.removeOne(Long.parseLong(earringsReadyId));
		}

		return "supprimer avec success";
	}

	@RequestMapping(value = "/ready/removeNecklaceReadyList", method = RequestMethod.POST)
	public String removeNecklaceReadyList(@RequestBody List<String> necklaceReadyIdList, Model model) {

		for (String id : necklaceReadyIdList) {
			String necklaceReadyId = id.substring(8);
			necklaceService.removeOne(Long.parseLong(necklaceReadyId));
		}

		return "supprimer avec success";
	}

}
