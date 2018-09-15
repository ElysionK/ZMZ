<<<<<<< HEAD
package com.tianwen.core.index.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;
import com.tianwen.core.index.dto.IndexDto;
import com.tianwen.core.index.service.IndexService;

@Scope("prototype")
@Controller
public class IndexController extends BaseController{
	
	@Autowired
	private IndexService indexService;

	@GetMapping(value = "/index")
	public ModelAndView toIndex(){
		IndexDto indexDto = indexService.getIndexDto();
		return new ModelAndView("/store/index", "data", indexDto);
	}
	
}
=======
package com.tianwen.core.index.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;
import com.tianwen.core.index.dto.IndexDto;
import com.tianwen.core.index.service.IndexService;

@Scope("prototype")
@Controller
public class IndexController extends BaseController{
	
	@Autowired
	private IndexService indexService;

	@GetMapping(value = "/index")
	public ModelAndView toIndex(){
		IndexDto indexDto = indexService.getIndexDto();
		return new ModelAndView("/store/index", "data", indexDto);
	}
	
}
>>>>>>> a656f0fd398429cbc4355a9fb2981e1567f7f9a3
