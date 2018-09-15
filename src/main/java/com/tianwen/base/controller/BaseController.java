package com.tianwen.base.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Scope("protopype")
public class BaseController {

	protected final static Log logger = LogFactory.getLog(BaseController.class);

	public static String URL404 = "/error/404";

	public ModelAndView redirect(String redirectUrl, Map<String, Object>... parament) {
		ModelAndView view = new ModelAndView(new RedirectView(redirectUrl));
		if (null != parament && parament.length > 0) {
			view.addAllObjects(parament[0]);
		}
		return view;
	}

	public ModelAndView redirect404() {
		return new ModelAndView(new RedirectView(URL404));
	}

	/**
	 * SpringMvc下获取request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;

	}

	/**
	 * SpringMvc下获取session
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		HttpSession session = getRequest().getSession();
		return session;
	}

	/**
	 * SpringMvc下获取response
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		return response;
	}
}
