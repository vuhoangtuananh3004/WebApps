package com.web.controller;



import java.io.IOException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.DAO.CreateAccountDAO;
import com.web.DAO.SendEmail;
import com.web.entity.UserAccount;

@Controller
@ComponentScan("com.web.service")
public class SignUpController {
	@Autowired
	CreateAccountDAO dao;
	@Autowired
	SendEmail sendEmail;
//	
//	Random random = new Random();
//	int code = random.nextInt();
//	try {
//		mail.sendEmail(user.getEmail(), code);
//	} catch (MessagingException e) {
//		e.printStackTrace();
//	}
	private int Code () {
		Random random = new Random();
		int code = random.nextInt(1000);
		return code;
	}
	
	@RequestMapping(value = "/SignUp", method = RequestMethod.GET)
	public String showSignUpPage(ModelMap model, HttpServletRequest request) {
		UserAccount userForm = new UserAccount();
		model.addAttribute("userForm", userForm);
		return "signup";
	}
	@RequestMapping(value = "/SignUp", method = RequestMethod.POST)
	public String signUpAccount (ModelMap model, @ModelAttribute ("userForm") UserAccount user, HttpServletRequest request, HttpSession session) throws AddressException, MessagingException, IOException {
		session = request.getSession();
		session.setAttribute("user", user);
		
		if (user.getEmail().isEmpty()) {
			model.addAttribute("error","Email can not empty");
			session.removeAttribute("user");
			return "signup";
		}else if (dao.existAccount(user.getEmail())){
			model.addAttribute("error","Email existed");
			session.removeAttribute("user");
			return "signup";
		}
		int code = Code();
		session.setAttribute("code", code);
		sendEmail.sendEmail(user.getEmail(), code );
	
		return "verification";
	}
	@RequestMapping (value = "/verification",method = RequestMethod.GET)
	public String getVerification (ModelMap model, HttpServletRequest request, HttpSession session) {
		session =request.getSession();
		UserAccount user =(UserAccount) session.getAttribute("user");
		model.addAttribute(user);
		
		return "verification";
		
	}
	
	
	@RequestMapping (value ="/verification", method = RequestMethod.POST)
	public String verification (ModelMap model, HttpServletRequest request, HttpSession session) {
		session = request.getSession();
		int code = (int) session.getAttribute("code");
		int codeInput = Integer.parseInt(request.getParameter("codeInput"));
		if (codeInput == code) {
			return "successfull";
		}
		
		return "verification";
		
	}
	
	

}
