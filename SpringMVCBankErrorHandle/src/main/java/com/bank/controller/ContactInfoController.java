package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.WebUtils;

import com.bank.entities.ContactInfo;
import com.bank.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;


@Controller
public class ContactInfoController {

	@Autowired
	private AccountService accountservice;

	@PostMapping("/contactinfo")
	public String saveCAccount(@Valid @ModelAttribute ContactInfo contactinfo, BindingResult result, HttpServletRequest request, Model model) {

		try {
			int accountid = (int) WebUtils.getSessionAttribute(request, "accountid");

			System.out.println("Account id in Bank info page :" + accountid);
			contactinfo.setAccountid(accountid);
			int save = accountservice.saveContactInfo(contactinfo);
			if (save != -1) {
				return "bankinfo";
			} else {
				return "contactinfo";
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "contactinfo";

		}
	}
}
