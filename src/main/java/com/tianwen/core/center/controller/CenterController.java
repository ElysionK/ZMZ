package com.tianwen.core.center.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;

@Scope("prototype")
@Controller
@RequestMapping(value = "center")
public class CenterController extends BaseController{

	@GetMapping(value = "/index")
	public ModelAndView toCenterIndex(){
		return new ModelAndView("/center/index");
	}
	
}
