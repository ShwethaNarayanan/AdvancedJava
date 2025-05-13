
package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.WebUtils;

import com.bank.entities.BankInfo;
import com.bank.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class BankInfoController {

	@Autowired
	private AccountService accountservice;

	@PostMapping("/bankinfo")
	public String saveBAccount(@Valid @ModelAttribute BankInfo bankinfo, BindingResult result, HttpServletRequest request, Model model) {

		try {
			int accountid = (int) WebUtils.getSessionAttribute(request, "accountid");

			System.out.println("Account id in Bank info page :" + accountid);
			bankinfo.setAccountid(accountid);
			int save = accountservice.saveBankInfo(bankinfo);
			if (save != -1) {
				return "success";
			} else {
				return "errorpage";
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "contactinfo";

		}
	}
}
