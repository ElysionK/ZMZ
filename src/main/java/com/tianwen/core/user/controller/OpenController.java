package com.tianwen.core.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.user.entity.User;
import com.tianwen.core.user.service.UserService;

@Scope("prototype")
@Controller
@RequestMapping(value = "/open")
public class OpenController extends BaseController{

	@Autowired
	private UserService userService;


	@GetMapping(value = "/loginSuccess")
	public ModelAndView toLoginSuccess() {
		
		return new ModelAndView("/store/index");
	}
	
	@GetMapping(value = "/toLogin")
	public ModelAndView toLogin() {
		
		return new ModelAndView("/user/login");
	}
	
	@GetMapping(value = "/toRegist")
	public ModelAndView toRegist() {
		
		return new ModelAndView("/user/regist");
	}
	
	@PostMapping(value = "/regist", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult regist(User user) {
		return userService.doRegist(user);
	}
	
	@PostMapping(value = "/login", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult login(User user) {
		return userService.doLogin(user);
	}
	

}
