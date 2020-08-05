package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.DAO.CreateAccountDAO;
import com.web.entity.UserAccount;



@Controller
@ComponentScan("com.web.service")
public class LoginController {
	
	@Autowired
	CreateAccountDAO dao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showMainPage() {
		return "index";
	}
	

}
