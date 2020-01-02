package com.mindtree.tourismapplication.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.tourismapplication.entity.Hotel;
import com.mindtree.tourismapplication.entity.State;
import com.mindtree.tourismapplication.entity.Tourism;
import com.mindtree.tourismapplication.service.TravelTourismService;

@Controller
public class TourismAppController {

	@Autowired
	private TravelTourismService travelTourismService;

	@GetMapping("/")
	public String index0() {
		return "index";
	}

	@GetMapping("/form")
	public String index1() {
		return "state";
	}

	@RequestMapping("/addState")
	public String addCustomerDetails(@ModelAttribute("state") State state) {
		travelTourismService.registerStateToDatabase(state);
		return "index";
	}

	@GetMapping("/form1")
	public String index1(Model model) {
		List<State> states = travelTourismService.getAllStatesFromDataBase();
		model.addAttribute("states", states);
		return "tourism";
	}

	@RequestMapping("/addTourism")
	public String addDebitCardDetailsToFlight(@RequestParam("stateId") int stateId,
			@ModelAttribute("tourism") Tourism tourism, Model model) {

		travelTourismService.addTourismDetails(stateId, tourism);
		return "index";
	}

	@GetMapping("/form2")
	private String index(Model model) {
		List<State> states = travelTourismService.getAllStatesFromDataBase();
		model.addAttribute("states", states);
		return "hotel";
	}

	@RequestMapping("/addHotel")
	public String buyingAVechile(@RequestParam("tourismId") int tourismId, @ModelAttribute("hotel") Hotel hotel) {
		travelTourismService.addHotelToDatabase(tourismId, hotel);
		return "index";

	}
}
