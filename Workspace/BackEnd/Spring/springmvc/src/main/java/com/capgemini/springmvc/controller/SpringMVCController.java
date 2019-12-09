package com.capgemini.springmvc.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.springmvc.bean.UserBean;

@Controller
public class SpringMVCController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}//End of initBinder()
	
	@RequestMapping(path="/hello", method = RequestMethod.GET)
	public ModelAndView displayHelloUser() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("/WEB-INF/view/helloUser.jsp");
		modelAndView.setViewName("helloUser");
		
		return modelAndView;
	}//End of displayHelloUser
	
	@RequestMapping(path = "/loginForm", method = RequestMethod.GET)
	public ModelAndView displayLoginForm() {
		ModelAndView modelAndView = new ModelAndView();
		/* modelAndView.setViewName("/WEB-INF/view/loginForm.jsp"); */
		modelAndView.setViewName("loginForm");
		return modelAndView;
		
	}//End of ModelAndView
	
	@RequestMapping(path = "/Login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, ModelAndView modelAndView) {
		String empIdVal = req.getParameter("empId");
		String password = req.getParameter("password");
		
		req.setAttribute("empId", empIdVal);
		req.setAttribute("pwd", password);
		
	//	modelAndView.setViewName("/WEB-INF/view/userDetail.jsp");
		modelAndView.setViewName("userDetail");
		return modelAndView;
	}//End of login
	
	@RequestMapping(path = "/Login2", method = RequestMethod.POST)
	public String login2(@RequestParam("empId") int empId,
			@RequestParam("password") String password, ModelMap modelMap) {
		
		modelMap.addAttribute("empId", empId);
		modelMap.addAttribute("pwd", password);
		
		//return "/WEB-INF/view/userDetail.jsp";	
		return "userDetail";
	}
	
	@PostMapping("/Login3")
	public String login3(int empId, String password, ModelMap modelMap) {
		modelMap.addAttribute("empId", empId);
		modelMap.addAttribute("pwd", password);
		
		return "userDetail";
		
	}
	@PostMapping("/Login4")
	public String login4(UserBean userBean, ModelMap modelMap) {
		modelMap.addAttribute("userBean", userBean);
		
		return "userDetail";
	}
}//End of Controller
