package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);
	
	@GetMapping("/greeting")
	public String greeting(Model model) {
		logger.debug("Invocado el greeting controller");
		model.addAttribute("name","Raul");
		return "greeting_template";
	}
	
	@GetMapping("/greeting_user")
	public String greetingUser(Model model, @RequestParam String nombre,@RequestParam String apellido,@RequestParam String calvo){ 
		//lo que ponemos en el modelo es lo que queremos que nos llegue como respuesta
		model.addAttribute("fullname",nombre+" "+apellido);
		model.addAttribute("name",nombre);
		model.addAttribute("lastname",apellido);
		model.addAttribute("requena",calvo);
		return "greetingUsers";
	}
	
	@GetMapping("/list")
	public String userList(Model model) {
		logger.debug("Invocado el greeting controller");
	 List<String> users = Arrays.asList("Kate","John","Kares","Max");
	 model.addAttribute("u", users);
	 return "users";
	}
	
	@Autowired
	UserRepository userRepo;
	@GetMapping("/databaseTrial")
	public String dbtrial (Model model) {
		List<Usuario> userList = userRepo.findAll();
		model.addAttribute("dbTrial", userList);
		return "databaseTrial";
	}
		
	}
	

