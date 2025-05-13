package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learn.beans.User;
import com.learn.dao.DaoService;

@Controller
public class MVController {
	
	@Autowired
	private JdbcTemplate jdbcTemp;
	
	@GetMapping("/loginPage")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping("/userLogin")
	public String userLogin(@ModelAttribute User user) {
		DaoService dao = new DaoService();
		user = dao.validateUser(user, jdbcTemp);
		String page;
		if(user.getFname() != null) {
			page = "registration";
		}
		else
			page = "login";
		return page;
	}

	@PostMapping("/register")
	public String register(@ModelAttribute User user, Model model) {
		model.addAttribute("fname", user.getFname());
		model.addAttribute("lname", user.getLname());
		return "welcome";
	}
}
