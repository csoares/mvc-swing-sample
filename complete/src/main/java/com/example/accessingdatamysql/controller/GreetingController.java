package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.entity.User;
import com.example.accessingdatamysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GreetingController {
	@Autowired
	private UserService userService;

	@GetMapping(path="/hello")
	public @ResponseBody
	String helloWorld(){
		return "hello world!";
	}

	@GetMapping("/")
	public String greeting() {
		return "index.html";
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/view/{id}")
	public String listUsers(@RequestParam(name="id")  Integer id, Model model) {
		User u=userService.getUserWithId(id);
		model.addAttribute("username", u.getUsername());
		model.addAttribute("email", u.getEmail());
		return "user";
	}

	@GetMapping("/list")
	public String listUAllsers(Model model) {
		List<User> users=userService.fetchUserList();
		model.addAttribute("users", users);
		return "list";
	}

}
