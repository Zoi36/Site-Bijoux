package com.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.admin.domain.Alliance;
import com.admin.domain.Earrings;
import com.admin.domain.Necklace;
import com.admin.domain.RingSimple;
import com.admin.service.AllianceService;
import com.admin.service.EarringsService;
import com.admin.service.NecklaceService;
import com.admin.service.RingSimpleService;

@Controller
@RequestMapping("/ready")
public class ReadyController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@Autowired
	private RingSimpleService ringSimpleService;

	@Autowired
	private AllianceService allianceService;

	@Autowired
	private EarringsService earringsService;

	@Autowired
	private NecklaceService necklaceService;

	@RequestMapping(value = "/addRingSimpleReady", method = RequestMethod.GET)
	public String addRingSimpleReady(Model model) {

		RingSimple ringSimpleReady = new RingSimple();
		model.addAttribute("ringSimpleReady", ringSimpleReady);
		return "/productReady/addRingSimpleReady";
	}

	@RequestMapping(value = "/addRingSimpleReady", method = RequestMethod.POST)
	public String addRingSimpleReadyPost(@ModelAttribute("ringSimpleReady") RingSimple ringSimpleReady,
			HttpServletRequest request) {

		ringSimpleService.save(ringSimpleReady);

		MultipartFile image = ringSimpleReady.getImage();

		try {
			byte[] bytes = image.getBytes();
			String name = ringSimpleReady.getId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/product/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/ready/ringSimpleReadyList";

	}

	@RequestMapping("/updateRingSimpleReady")
	public String updateRingSimpleReady(@RequestParam("id") Long id, Model model) {

		RingSimple ringSimpleReady = ringSimpleService.findOne(id);
		model.addAttribute("ringSimpleReady", ringSimpleReady);

		return "/productReady/updateRingSimpleReady";
	}

	@RequestMapping(value = "/updateRingSimpleReady", method = RequestMethod.POST)
	public String updateRingSimpleReadyPost(@ModelAttribute("ringSimpleReady") RingSimple ringSimpleReady,
			HttpServletRequest request) {
		ringSimpleService.save(ringSimpleReady);

		MultipartFile image = ringSimpleReady.getImage();

		if (!image.isEmpty()) {
			try {
				byte[] bytes = image.getBytes();
				String name = ringSimpleReady.getId() + ".png";

				Files.delete(Paths.get("src/main/resources/static/image/product/" + name));

				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/product/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "redirect:/ready/ringSimpleReadyList";
	}

	@RequestMapping("/ringSimpleReadyList")
	public String ringSimpleReadyList(Model model) {
		List<RingSimple> ringSimpleReadyList = ringSimpleService.findAll();
		model.addAttribute("ringSimpleReadyList", ringSimpleReadyList);

		return "/productReady/ringSimpleReadyList";

	}

	@RequestMapping(value = "/removeRingSimpleReady", method = RequestMethod.POST)
	public String removeRingSimpleReady(@ModelAttribute("id") String id, Model model) {
		ringSimpleService.removeOne(Long.parseLong(id.substring(8)));
		List<RingSimple> ringSimpleReadyList = ringSimpleService.findAll();
		model.addAttribute("ringSimpleReadyList", ringSimpleReadyList);

		return "redirect:/ready/ringSimpleReadyList";
	}

	@RequestMapping(value = "/addAllianceReady", method = RequestMethod.GET)
	public String addAllianceReady(Model model) {

		Alliance allianceReady = new Alliance();
		model.addAttribute("allianceReady", allianceReady);
		return "/productReady/addAllianceReady";
	}

	@RequestMapping(value = "/addAllianceReady", method = RequestMethod.POST)
	public String addAllianceReadyPost(@ModelAttribute("allianceReady") Alliance allianceReady,
			HttpServletRequest request) {

		allianceService.save(allianceReady);

		MultipartFile image = allianceReady.getImage();

		try {
			byte[] bytes = image.getBytes();
			String name = allianceReady.getId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/product/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/ready/allianceReadyList";

	}

	@RequestMapping("/updateAllianceReady")
	public String updateAllianceReady(@RequestParam("id") Long id, Model model) {
		Alliance allianceReady = allianceService.findOne(id);
		model.addAttribute("allianceReady", allianceReady);

		return "/productReady/updateAllianceReady";
	}

	@RequestMapping(value = "/updateAllianceReady", method = RequestMethod.POST)
	public String updatAllianceReadyPost(@ModelAttribute("allianceReady") Alliance allianceReady,
			HttpServletRequest request) {
		allianceService.save(allianceReady);

		MultipartFile image = allianceReady.getImage();

		if (!image.isEmpty()) {
			try {
				byte[] bytes = image.getBytes();
				String name = allianceReady.getId() + ".png";

				Files.delete(Paths.get("src/main/resources/static/image/product/" + name));

				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/product/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "redirect:/ready/allianceReadyList";
	}

	@RequestMapping("allianceReadyList")
	public String allianceReadyList(Model model) {
		List<Alliance> allianceReadyList = allianceService.findAll();
		model.addAttribute("allianceReadyList", allianceReadyList);

		return "/productReady/allianceReadyList";

	}

	@RequestMapping(value = "/removeAllianceReady", method = RequestMethod.POST)
	public String removeAllianceReady(@ModelAttribute("id") String id, Model model) {
		allianceService.removeOne(Long.parseLong(id.substring(8)));
		List<Alliance> allianceReadyList = allianceService.findAll();
		model.addAttribute("allianceReadyList", allianceReadyList);

		return "redirect:/ready/productReady/allianceReadyList";
	}

	@RequestMapping(value = "/addEarringsReady", method = RequestMethod.GET)
	public String addEarringsReady(Model model) {

		Earrings earringsReady = new Earrings();
		model.addAttribute("earringsReady", earringsReady);
		return "/productReady/addEarringsReady";
	}

	@RequestMapping(value = "/addEarringsReady", method = RequestMethod.POST)
	public String addEarringsReadyPost(@ModelAttribute("earringsReady") Earrings earringsReady,
			HttpServletRequest request) {

		earringsService.save(earringsReady);

		MultipartFile image = earringsReady.getImage();

		try {
			byte[] bytes = image.getBytes();
			String name = earringsReady.getId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/product/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/ready/earringsReadyList";

	}

	@RequestMapping("/updateEarringsReady")
	public String updateEarringsReady(@RequestParam("id") Long id, Model model) {
		Earrings earringsReady = earringsService.findOne(id);
		model.addAttribute("earringsReady", earringsReady);

		return "/productReady/updateEarringsReady";
	}

	@RequestMapping(value = "/updateEarringsReady", method = RequestMethod.POST)
	public String updateEarringsReadyPost(@ModelAttribute("earringsReady") Earrings earringsReady,
			HttpServletRequest request) {
		earringsService.save(earringsReady);

		MultipartFile image = earringsReady.getImage();

		if (!image.isEmpty()) {
			try {
				byte[] bytes = image.getBytes();
				String name = earringsReady.getId() + ".png";

				Files.delete(Paths.get("src/main/resources/static/image/product/" + name));

				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/product/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "redirect:/ready/earringsReadyList";
	}

	@RequestMapping("/earringsReadyList")
	public String earringsReadyList(Model model) {
		List<Earrings> earringsReadyList = earringsService.findAll();
		model.addAttribute("earringsReadyList", earringsReadyList);

		return "/productReady/earringsReadyList";

	}

	@RequestMapping(value = "/removeEarringsReady", method = RequestMethod.POST)
	public String removeEarringsReady(@ModelAttribute("id") String id, Model model) {
		earringsService.removeOne(Long.parseLong(id.substring(8)));
		List<Earrings> earringsReadyList = earringsService.findAll();
		model.addAttribute("earringsReadyList", earringsReadyList);

		return "redirect:/ready/earringsReadyList";
	}

	@RequestMapping(value = "/addNecklaceReady", method = RequestMethod.GET)
	public String addNecklaceReady(Model model) {

		Necklace necklaceReady = new Necklace();
		model.addAttribute("necklaceReady", necklaceReady);
		return "/productReady/addNecklaceReady";
	}

	@RequestMapping(value = "/addNecklaceReady", method = RequestMethod.POST)
	public String addNecklaceReadyPost(@ModelAttribute("ringSimpleReady") Necklace necklaceReady,
			HttpServletRequest request) {

		necklaceService.save(necklaceReady);

		MultipartFile image = necklaceReady.getImage();

		try {
			byte[] bytes = image.getBytes();
			String name = necklaceReady.getId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/product/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/ready/necklaceReadyList";

	}

	@RequestMapping("/updateNecklaceReady")
	public String updateNecklaceReady(@RequestParam("id") Long id, Model model) {
		Necklace necklaceReady = necklaceService.findOne(id);
		model.addAttribute("necklaceReady", necklaceReady);

		return "/productReady/updateNecklaceReady";
	}

	@RequestMapping(value = "/updateNecklaceReady", method = RequestMethod.POST)
	public String updateNecklaceReadyPost(@ModelAttribute("necklaceReady") Necklace necklaceReady,
			HttpServletRequest request) {
		necklaceService.save(necklaceReady);

		MultipartFile image = necklaceReady.getImage();

		if (!image.isEmpty()) {
			try {
				byte[] bytes = image.getBytes();
				String name = necklaceReady.getId() + ".png";

				Files.delete(Paths.get("src/main/resources/static/image/product/" + name));

				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/product/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "redirect:/ready/necklaceReadyList";
	}

	@RequestMapping("/necklaceReadyList")
	public String necklaceReadyList(Model model) {

		List<Necklace> necklaceReadyList = necklaceService.findAll();
		model.addAttribute("necklaceReadyList", necklaceReadyList);

		return "/productReady/necklaceReadyList";

	}

	@RequestMapping(value = "/removeNecklaceReady", method = RequestMethod.POST)
	public String removeNecklaceReady(@ModelAttribute("id") String id, Model model) {
		necklaceService.removeOne(Long.parseLong(id.substring(8)));
		List<Necklace> necklaceReadyList = necklaceService.findAll();
		model.addAttribute("necklaceReadyList", necklaceReadyList);

		return "redirect:/ready/necklaceReadyList";
	}

}
