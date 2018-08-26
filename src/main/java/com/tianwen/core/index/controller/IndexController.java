package com.tianwen.core.index.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;
import com.tianwen.core.backstage.dao.BackDao;
import com.tianwen.core.backstage.dto.CategoryDto;

@Scope("prototype")
@Controller
public class IndexController extends BaseController{
	
	@Autowired
	private BackDao backDao;

	@GetMapping(value = "/index")
	public ModelAndView toIndex(){
		List<CategoryDto> categories = backDao.findAllCategories();
		return new ModelAndView("/store/index", "categories", categories);
	}
	
}
