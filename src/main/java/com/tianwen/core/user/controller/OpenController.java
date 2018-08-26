package com.tianwen.core.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;
import com.tianwen.core.user.service.UserService;

@Scope("prototype")
@Controller
@RequestMapping(value = "/open")
public class OpenController extends BaseController{

	@Autowired
	private UserService userService;


	@GetMapping(value = "/logSuccess")
	public ModelAndView toLoginSuccess() {
		
		return new ModelAndView("/store/index");
	}
	

}
