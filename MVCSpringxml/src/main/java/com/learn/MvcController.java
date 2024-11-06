package com.learn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MvcController {
	
	@RequestMapping(value = {"/", "/welcome"} , method = RequestMethod.GET)
	public ModelAndView welcome() {
		
		ModelAndView maview = new ModelAndView();
		maview.setViewName("welcome");
		return maview;
	}

}
