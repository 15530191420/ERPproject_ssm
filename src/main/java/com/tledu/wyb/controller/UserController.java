package com.tledu.wyb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tledu.wyb.model.Dept;
import com.tledu.wyb.model.User;
import com.tledu.wyb.service.IUserService;
import com.tledu.wyb.util.AjaxObj;
import com.tledu.wyb.util.ERPException;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/list")
	public String list(HttpSession session,Model model) {
		//如果登录 获取所有的用户 传递到页面
		List<User> users = userService.list();
		session.setAttribute("users", users);
		model.addAttribute("users", users);
		return "user/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		userService.delete(id);
		return "redirect:/user/list";
	}
	@RequestMapping("/add")
	public String add() {
		return "user/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(User user,HttpSession session,Model model) throws  ERPException{
//		List<Dept> depts = (List<Dept>) session.getAttribute("depts");
//		model.addAttribute("depts", depts);
		userService.add(user);
		return "redirect:/user/list";
		
	}
	
	@RequestMapping("/updateInput")
	public String update(User user,Model model) {
		int i = user.getId();
		User oldUser = userService.load(i);
		model.addAttribute("user", oldUser);
		System.out.println(oldUser.getUsername());
		return "user/update";
	}

	@RequestMapping(value = "/updateInput", method = RequestMethod.POST)
	public String update(User user,HttpSession session,Model model) throws  ERPException{
		
		userService.update(user);
		return "redirect:/user/list";
		
	}
}
