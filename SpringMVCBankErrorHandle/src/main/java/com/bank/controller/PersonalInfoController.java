package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bank.entities.PersonalInfo;
import com.bank.service.AccountService;

@Controller
@ControllerAdvice
@SessionAttributes("accountid")
public class PersonalInfoController {

	@Autowired
	private AccountService accountservice;

	@Autowired
	private Validator validator;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/personalinfog")
	public String getPersonalInfoPage(@ModelAttribute PersonalInfo personalInfo) {
		return "personalinfo";
	}


	@RequestMapping("/personalinfo")
	public String savePAccount(@Validated @ModelAttribute PersonalInfo personalInfo, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			return "personalinfo";
		} else {

			try {
				int accountid = accountservice.savePersonalInfo(personalInfo);
				if (accountid != -1) {
					return "contactinfo";
				} else {
					return "personalinfo";
				}
			} catch (Exception e) {
				model.addAttribute("error", e.getMessage());
				return "personalinfo";
			}
		}

	}

}
