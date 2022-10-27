package com.heekwoncompany.study011;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return "/login";
	}
	
	@RequestMapping(value = "/loginok")
	public String loginok(HttpServletRequest request,Model model) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("admin")&&pw.equals("12345")) {
			model.addAttribute("name", "[관리자]");
		}
		else if(id.equals("user")&&pw.equals("12345")) {
			model.addAttribute("name", "[사용자]");
		}
		else {
			model.addAttribute("name", "[비회원]");
		}
		
		
		return "/loginok";
	}
}
