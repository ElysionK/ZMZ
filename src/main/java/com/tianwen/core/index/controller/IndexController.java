package com.tianwen.core.index.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;

@Scope("prototype")
@Controller
public class IndexController extends BaseController{

	@GetMapping(value = "/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/store/index");
	}
	
}
