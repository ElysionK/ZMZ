package com.tianwen.core.backstage.controller;

import java.io.IOException;
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
import com.tianwen.common.SysConstant;
import com.tianwen.common.util.ImageUtil;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.dto.OfflineOrderCondition;
import com.tianwen.core.backstage.dto.OnlineOrderCondition;
import com.tianwen.core.backstage.dto.ProductCondition;
import com.tianwen.core.backstage.dto.RegistCodeCondition;
import com.tianwen.core.backstage.dto.UserCondition;
import com.tianwen.core.backstage.entity.Admin;
import com.tianwen.core.backstage.entity.Banner;
import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.backstage.entity.TOfflineOrder;
import com.tianwen.core.backstage.service.BackService;

@Scope("prototype")
@Controller
@RequestMapping(value = "/backstage")
public class BackContrller extends BaseController {

	@Autowired
	private BackService backService;
	
	@Autowired
	private ImageUtil imageUtil;

	/**************************************
	 * registCode
	 ***********************************************/
	@GetMapping(value = "/registCode/list")
	public ModelAndView toRegistCodeList() {
		return new ModelAndView("/code/list");
	}

	@PostMapping(value = "/registCode/ajaxLoadRegistCode/{pageNo}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult ajaxLoadRegistCode(@PathVariable String pageNo, RegistCodeCondition condition) {
		return backService.findAllRegistCode(pageNo, condition);
	}

	@PostMapping(value = "/registCode/add/{codeCount}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult addReigstCode(@PathVariable Integer codeCount) {
		return backService.addRegistCode(codeCount);
	}

	/**************************************
	 * banner
	 ***********************************************/
	@GetMapping(value = "/banner/list")
	public ModelAndView toBannerList() {
		List<Banner> list = backService.findAllBanners();
		return new ModelAndView("/banner/list", "list", list);
	}

	@GetMapping(value = "/banner/add")
	public ModelAndView toAddBanner() {
		return new ModelAndView("/banner/add");
	}

	@PostMapping(value = "/banner/addNew", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult addNew(Banner banner, MultipartFile mainFile, HttpServletRequest request) {
		String path = imageUtil.saveFile(mainFile, "banner");
		banner.setImg(path);
		return backService.addNewBanner(banner);
	}

	@PostMapping(value = "/banner/sort/update", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult updBannerSort(@RequestBody List<Banner> banners) {
		return backService.updBannerSort(banners);
	}

	@PostMapping(value = "/banner/update", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult updBanner(Banner banner, MultipartFile mainFile, HttpServletRequest request) {
		if (mainFile != null && !mainFile.isEmpty()) {
			String path = imageUtil.saveFile(mainFile, "banner");
			banner.setImg(path);
		}
		return backService.updBanner(banner);
	}

	/*************************************
	 * category
	 *******************************************/
	@GetMapping(value = "/index")
	public ModelAndView toBackIndex() {
		return new ModelAndView("/back_index");
	}

	@GetMapping(value = "/category/list")
	public ModelAndView toCategoryList() {
		List<CategoryDto> list = backService.findAllCategories();
		return new ModelAndView("/category/list", "list", list);
	}

	@GetMapping(value = "/category/add")
	public ModelAndView toAddCategory() {
		return new ModelAndView("/category/add");
	}

	@PostMapping(value = "/category/addNew", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult addNew(CategoryDto dto, MultipartFile mainFile, HttpServletRequest request) {
		String path = imageUtil.saveFile(mainFile, "category");
		dto.setImg(path);
		return backService.addNewCategory(dto);
	}

	@PostMapping(value = "/category/sort/update", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult updCategorySort(@RequestBody List<CategoryDto> categories) {
		return backService.updCategorySort(categories);
	}

	@PostMapping(value = "/category/update", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult updCategory(CategoryDto dto, MultipartFile mainFile, HttpServletRequest request) {
		if (mainFile != null && !mainFile.isEmpty()) {
			String path = imageUtil.saveFile(mainFile, "category");
			dto.setImg(path);
		}
		return backService.updCategory(dto);
	}

	/**********************************
	 * product
	 ******************************************/

	@GetMapping(value = "/product/list")
	public ModelAndView toProductList() {
		List<CategoryDto> categories = backService.findAllCategories();
		return new ModelAndView("/product/list", "data", categories);
	}

	@PostMapping(value = "/product/ajaxLoadProduct/{pageNo}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult ajaxLoadProduct(@PathVariable String pageNo, @RequestBody ProductCondition condition) {
		JsonResponseResult result = null;
		// List<Product> list = backService.findAllProducts();
		Pager pager = backService.findAllProducts(condition, pageNo);
		String ajaxPage = pager.getSiAjaxPageHtml();
		result = JsonResponseResult.createSuccess();
		result.addData(pager);
		result.addData(ajaxPage);
		return result;
	}

	@GetMapping(value = "/product/add")
	public ModelAndView toAddProduct() {
		List<CategoryDto> list = backService.findAllCategories();
		return new ModelAndView("/product/add", "list", list);
	}

	@PostMapping(value = "/product/addNew", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult addNew(Product product, MultipartFile mainFile, HttpServletRequest request) {
		String path = imageUtil.saveFile(mainFile, "product");
		product.setImg(path);
		return backService.addNewProduct(product);
	}

	/**************************************
	 * onlineOrder
	 ***********************************************/
	@GetMapping(value = "/onlineOrder/list")
	public ModelAndView toOnlineOrderList() {
		return new ModelAndView("/onlineOrder/list");
	}

	@PostMapping(value = "/onlineOrder/ajaxLoadOnlineOrder/{pageNo}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult ajaxLoadOnineOrder(@PathVariable String pageNo, @RequestBody OnlineOrderCondition condition) {
		return backService.listOnlineOrder(pageNo, condition);
	}
	
	@PostMapping(value = "/onlineOrder/ajaxLoadDetail/{oid}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult ajaxLoadOnineOrderDetail(@PathVariable Integer oid) {
		return backService.listOnlineOrderDetailByOid(oid);
	}

	/**************************************
	 * offlineOrder
	 ***********************************************/
	@GetMapping(value = "/offlineOrder/list")
	public ModelAndView toOfflineOrderList() {
		return new ModelAndView("/offlineOrder/list");
	}

	@PostMapping(value = "/offlineOrder/ajaxLoadOfflineOrder/{pageNo}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult ajaxLoadOfflineOrder(@PathVariable String pageNo, @RequestBody OfflineOrderCondition condition) {
		return backService.listOfflineOrder(pageNo, condition);
	}

	@PostMapping(value = "/offlineOrder/upload", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult addOfflineOrder(MultipartFile excel) throws IOException {
		return backService.addOfflineOrderList(excel);
	}

	@PostMapping(value = "/offlineOrder/update", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult updOfflineOrder(TOfflineOrder order) {
		return backService.updOfflineOrder(order);
	}

	@PostMapping(value = "/offlineOrder/del/{id}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult updOfflineOrder(@PathVariable String id) {
		return backService.delOfflineOrderById(Integer.valueOf(id));
	}
	
	/************ admin login  **********/
	@GetMapping(value = "/toLogin")
	public ModelAndView toLogin() {
		return new ModelAndView("/login");
	}
	
	@PostMapping(value = "/adminLogin", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult login(@RequestBody Admin admin) {
		JsonResponseResult result = backService.doLogin(admin);
		if(result.getReturncode() == 0){
			super.getSession().setAttribute(SysConstant.SYS_ADMIN_LOG_SUCC_INFO, result.getData().get(0));
		}
		return result;
	}
	
	@PostMapping(value = "/logout", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult logout() {
		super.getSession().removeAttribute(SysConstant.SYS_ADMIN_LOG_SUCC_INFO);
		return JsonResponseResult.createSuccess();
	}
	
	/************** modify admin info *************************/
	@GetMapping(value = "/admin/center")
	public ModelAndView toAdminCenter() {
		Admin admin = (Admin) super.getSession().getAttribute(SysConstant.SYS_ADMIN_LOG_SUCC_INFO);
		return new ModelAndView("/center", "admin", admin);
	}
	
	@PostMapping(value = "/modify/adminInfo", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult modifyAdminInfo(@RequestBody Admin admin) {
		Admin oldAdmin = (Admin) super.getSession().getAttribute(SysConstant.SYS_ADMIN_LOG_SUCC_INFO);
		admin.setId(oldAdmin.getId());
		return backService.updAdmin(admin);
	}
	
	/*********   users ************/
	@GetMapping(value = "/user/list")
	public ModelAndView toUserList() {
		return new ModelAndView("/user/list");
	}

	@PostMapping(value = "/user/ajaxLoadUser/{pageNo}", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResponseResult ajaxLoadUser(@PathVariable String pageNo, @RequestBody UserCondition condition) {
		return backService.listUser(pageNo, condition);
	}

	

}
