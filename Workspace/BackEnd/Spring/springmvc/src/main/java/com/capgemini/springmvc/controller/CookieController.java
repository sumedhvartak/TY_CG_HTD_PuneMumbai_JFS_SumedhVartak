package com.capgemini.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {
	
	@GetMapping("/cookiePage")
	public String displayCookiePage() {
		return "cookiePage";
	}//End of CookieController
	
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse resp,ModelMap modelMap) {
		Cookie myCookie = new Cookie("name", "Sumedh");
		resp.addCookie(myCookie);
		
		modelMap.addAttribute("msg", "Create Cookie Successfully");
		return "cookiePage";
	}//End of CreateCookie
	
	@GetMapping("/readCookie")
	public String readCookie(@CookieValue(name = "name") String name, ModelMap modelMap) {
		modelMap.addAttribute("msg","Cookie value is" + name);
		return "cookiePage";
	}//End of ReadCookie
	
}//End of CookieController
