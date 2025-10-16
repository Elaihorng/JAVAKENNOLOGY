package com.setec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.setec.entities.Booked;
import com.setec.repos.BookedRepo;
import com.setec.telegrambot.MyTelegramBot;

@Controller
public class MyController {
 
	//http://localhost:8080/home
	@GetMapping({"/","/home"})
	
	public String home(Model mod) {
		Booked booked = new Booked(1,"kenn","056959395","kenn@gmail.com","03/13/2000","2:00 PM",2);
		mod.addAttribute("booked",booked);
		return "index";
	}
	@GetMapping({"/about"})
	public String about() {
		
		return "about";
	}
	@GetMapping({"/contact"})
	public String contact() {
		
		return "contact";
	}
	@GetMapping({"/menu"})
	public String menu() {
		
		return "menu";
	}
	@GetMapping({"/reservation"})
	public String reservation(Model mod) {
		
		Booked booked = new Booked(1,"kenn","056959395","kenn@gmail.com","03/13/2000","2:00 PM",2);
		mod.addAttribute("booked",booked);
		return "reservation";
	}
	@GetMapping({"service"})
	public String service() {
		
		return "service";
	}
	@GetMapping({"/testimonial"})
	public String testimonial() {
		
		return "testimonial";
	}
	@Autowired
	private BookedRepo bookedRepo;
	
	@Autowired
	private MyTelegramBot bot;
	
	@PostMapping({"/success"})
	public String success(@ModelAttribute Booked booked) {
		bookedRepo.save(booked);
		String message = String.format(
			    "👤 name: %s\n🆔 id: %d\n📱 phone: %s\n📧 email: %s\n📅 date: %s\n🕒 time: %s\n👥 person: %d",
			    booked.getName(),
			    booked.getId(),
			    booked.getPhoneNumber(),
			    booked.getEmail(),
			    booked.getDate(),
			    booked.getTime(),
			    booked.getPerson()
			);

		bot.message(message);
		return "success";
	}
}
