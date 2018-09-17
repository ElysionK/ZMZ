package com.tianwen.core.user.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import com.tianwen.common.SysConstant;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.core.user.entity.Area;
import com.tianwen.core.user.entity.User;
import com.tianwen.core.user.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
		JsonResponseResult result = userService.doLogin(user);
		if(result.getReturncode() == 0){
			super.getSession().setAttribute(SysConstant.SYS_MEMBER_LOG_SUCC_INFO, result.getData().get(0));
		}
		return result;
	}
	
//	@RequestMapping(value = "/area")
//	@ResponseBody
//	public JsonResponseResult area(User user) {
//		List<Area> areas = userService.findArea();
//
//		List<JSONObject> list = new ArrayList<>();
//		List<Area> province = areas.stream().filter(area -> area.getParentid() == 0).collect(Collectors.toList());
//		for (int i = 0; i < province.size(); i++) {
//			int id = province.get(i).getId();
//			JSONObject proObj = new JSONObject();
//			List<Object> cityList = new ArrayList<>();
//			
//			List<Area> city = areas.stream().filter(area -> area.getParentid() == id).collect(Collectors.toList());
//			for (int j = 0; j < city.size(); j++) {
//				int id2 = city.get(j).getId();
//				JSONObject cityObj = new JSONObject();
//				
//				List<Area> ex = areas.stream().filter(area -> area.getParentid() == id2).collect(Collectors.toList());
//				List<String> exList = new ArrayList<>();
//				for (int k = 0; k < ex.size(); k++) {
//					exList.add(ex.get(k).getTitle().trim().replaceAll("\\s*|\t|\r|\n", "") + "|" + ex.get(k).getId());
//				}
//				cityObj.put("a", exList);
//				cityObj.put("n", city.get(j).getTitle().trim().replaceAll("\\s*|\t|\r|\n", "") + "|" + city.get(j).getId());
//				cityList.add(cityObj);
//			}
//			proObj.put("c", cityList);
//			proObj.put("n", province.get(i).getTitle().trim().replaceAll("\\s*|\t|\r|\n", "") + "|" + province.get(i).getId());
//			list.add(proObj);
//		}
//		String str = JSONArray.fromObject(list).toString().replaceAll("\\s*|\t|\r|\n", "");
//		System.out.println(str);
//		
//		JsonResponseResult result = JsonResponseResult.createSuccess();
//		result.addData(str);
//		return result;
//	}

}
