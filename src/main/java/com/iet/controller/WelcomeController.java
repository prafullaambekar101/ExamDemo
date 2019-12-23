package com.iet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iet.bean.User;
import com.iet.service.UserService;

@Controller
public class WelcomeController {
	Logger logger=Logger.getLogger(WelcomeController.class);
	@Autowired UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}
	@RequestMapping("/signup")
	public String getSignUp(Model model) {
		model.addAttribute("command", new User());
		return "signup";
	}
	@RequestMapping(value="/signup",method = RequestMethod.POST)
	public String postSignUp(Model model,@Valid @ModelAttribute("command") User user,BindingResult result) {
		if(result.hasErrors()) {
			return "signup";
		}
		logger.warn(user);
		userService.add(user);
		return "index";
	}
	@RequestMapping("/signin")
	public String getSignIn(Model model) {
		model.addAttribute("command", new User());
		return "signin";
	}
}
