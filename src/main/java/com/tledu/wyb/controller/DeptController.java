package com.tledu.wyb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tledu.wyb.model.Dept;
import com.tledu.wyb.model.User;
import com.tledu.wyb.service.IDeptService;
import com.tledu.wyb.util.ERPException;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private IDeptService deptService;
	
	@RequestMapping("/list")
	public String list(HttpSession session , Model model) {
		List<Dept> depts = deptService.list();
		session.setAttribute("depts", depts);
		model.addAttribute("depts", depts);
		return "dept/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) throws ERPException {
		deptService.delete(id);
		return "redirect:/dept/list";
	}
	
	@RequestMapping("/addInput")
	public String add() {
		return "dept/add";
	}

	@RequestMapping(value = "/addInput", method = RequestMethod.POST)
	public String add(Dept dept,HttpSession session) throws  ERPException{
		deptService.add(dept);
		return "redirect:/dept/list";
	}
	@RequestMapping("/updateInput")
	public String update(Dept dept,Model model) {
//		int i = user.getId();
//		User oldUser = userService.load(i);
//		model.addAttribute("user", oldUser);
//		System.out.println(oldUser.getUsername());
		int i=dept.getId();
		Dept oldDept = deptService.load(i);
		System.out.println(oldDept.getName());
		model.addAttribute("dept", oldDept);
		return "dept/update";
	}

	@RequestMapping(value = "/updateInput", method = RequestMethod.POST)
	public String update(Dept dept,HttpSession session) throws  ERPException{
		
		deptService.update(dept);
		return "redirect:/dept/list";
	}
}
