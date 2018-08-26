package com.tianwen.core.backstage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tianwen.base.controller.BaseController;
import com.tianwen.base.util.Pager;
import com.tianwen.common.util.ImageUtil;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.dto.ProductCondition;
import com.tianwen.core.backstage.entity.Banner;
import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.backstage.service.BackService;

@Scope("prototype")
@Controller
@RequestMapping(value = "/backstage")
public class BackContrller extends BaseController {
	
	@Autowired
	private BackService backService;
	
	/************************************** banner ***********************************************/
	@GetMapping(value = "/banner/list")
	public ModelAndView toBannerList(){
		List<Banner> list = backService.findAllBanners();
		return new ModelAndView("/banner/list", "list", list);
	}
	
	@GetMapping(value = "/banner/add")
	public ModelAndView toAddBanner(){
		return new ModelAndView("/banner/add");
	}
	
	@PostMapping(value = "/banner/addNew", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult addNew(Banner banner, MultipartFile mainFile, HttpServletRequest request){
		String path = ImageUtil.saveFile(mainFile, request, "banner");
		banner.setImg(path);
		return backService.addNewBanner(banner);
	}
	
	
	
	/************************************* category *******************************************/
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
		//List<Product> list = backService.findAllProducts();
		return new ModelAndView("/product/list");
	}
	
	@PostMapping(value = "/product/ajaxLoadProduct/{pageNo}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult ajaxLoadProduct(@PathVariable String pageNo, ProductCondition condition){
		JsonResponseResult result = null;
		//List<Product> list = backService.findAllProducts();
		Pager pager = backService.findAllProducts(condition, pageNo);
		String ajaxPage = pager.getSiAjaxPageHtml();
		result = JsonResponseResult.createSuccess();
		result.addData(pager);
		result.addData(ajaxPage);
		return result;
	}
	
	@GetMapping(value = "/product/add")
	public ModelAndView toAddProduct(){
		List<CategoryDto> list = backService.findAllCategories();
		return new ModelAndView("/product/add", "list", list);
	}
	
	@PostMapping(value = "/product/addNew", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult addNew(Product product, MultipartFile mainFile, HttpServletRequest request){
		String path = ImageUtil.saveFile(mainFile, request, "product");
		product.setImg(path);
		return backService.addNewProduct(product);
	}
	
}
