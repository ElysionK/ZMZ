package com.tianwen.core.backstage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;
import com.tianwen.common.util.ImageUtil;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.backstage.service.BackService;

@Scope("prototype")
@Controller
@RequestMapping(value = "/backstage")
public class BackContrller extends BaseController {
	
	@Autowired
	private BackService backService;
	
<<<<<<< HEAD
	/************************************** banner ***********************************************/

	
	@GetMapping(value = "/banner/list")
	public ModelAndView toBannerList(){
		List<CategoryDto> list = backService.findAllCategories();
		return new ModelAndView("/banner/list", "list", list);
	}
	
	@GetMapping(value = "/banner/add")
	public ModelAndView toAddBanner(){
		return new ModelAndView("/banner/add");
	}
	
	
	
	/************************************* category *******************************************/
	
=======
>>>>>>> f803b43d402831835b6cf7a762839d4cceee0543

	@GetMapping(value = "/index")
	public ModelAndView toBackIndex(){
		return new ModelAndView("/back_index");
	}
	
	@GetMapping(value = "/category/list")
	public ModelAndView toCategoryList(){
		List<CategoryDto> list = backService.findAllCategories();
		return new ModelAndView("/category/list", "list", list);
	}
	
	@GetMapping(value = "/category/add")
	public ModelAndView toAddCategory(){
		return new ModelAndView("/category/add");
	}
	
	@PostMapping(value = "/category/addNew", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult addNew(CategoryDto dto, MultipartFile mainFile, HttpServletRequest request){
		String path = ImageUtil.saveFile(mainFile, request, "category");
		dto.setImg(path);
		return backService.addNewCategory(dto);
	}
	
	
	/********************************** product ******************************************/
	
	@GetMapping(value = "/product/list")
	public ModelAndView toProductList(){
		List<Product> list = backService.findAllProducts();
		return new ModelAndView("/product/list", "list", list);
	}
	
	@GetMapping(value = "/product/add")
	public ModelAndView toAddProduct(){
		return new ModelAndView("/product/add");
	}
	
	@PostMapping(value = "/product/addNew", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult addNew(Product product, MultipartFile mainFile, HttpServletRequest request){
		String path = ImageUtil.saveFile(mainFile, request, "product");
		product.setImg(path);
		return backService.addNewProduct(product);
	}
	
}
