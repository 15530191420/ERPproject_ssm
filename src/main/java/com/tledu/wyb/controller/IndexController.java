package com.tledu.wyb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tledu.wyb.model.User;
import com.tledu.wyb.service.IUserService;
import com.tledu.wyb.util.ERPException;

@Controller
public class IndexController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping({"/","/login"})
	public String login() {
		return "login";
	}
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user,HttpSession session) throws  ERPException{
		System.out.println(user);
		User loginUser = userService.login(user);
		//把登录信息保存到session中
		session.setAttribute("loginUser", loginUser);
		return "redirect:/index";
		
	}
}
