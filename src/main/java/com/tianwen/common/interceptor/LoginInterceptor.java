package com.tianwen.common.interceptor;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tianwen.common.SysConstant;
import com.tianwen.common.log.LogUtils;
import com.tianwen.common.util.AESUtil;
import com.tianwen.common.util.CookieUtil;
import com.tianwen.common.util.StringUtils;
import com.tianwen.common.util.SysUtils;
import com.tianwen.core.user.entity.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private List<String> exceptUrls;

	public List<String> getExceptUrls() {
		return exceptUrls;
	}

	public void setExceptUrls(List<String> exceptUrls) {
		this.exceptUrls = exceptUrls;
	}
	
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();		
		String requestUri = request.getRequestURI();//请求原始地址		
		String retUrl = request.getHeader("Referer");
		User user = (User) session.getAttribute(SysConstant.SYS_MEMBER_LOG_SUCC_INFO);
		// LogUtils.info(LoginInterceptor.class,"请求的上一个地址："+retUrl);
		if (requestUri.startsWith(request.getContextPath())) {
			requestUri = requestUri.substring(request.getContextPath().length(), requestUri.length());
		}
		LogUtils.info(LoginInterceptor.class, "请求原始地址：" + requestUri);
		

		// 放行exceptUrls中配置的url
		for (String url : exceptUrls) {
			if (url.endsWith("/**")) {
				if (requestUri.startsWith(url.substring(0, url.length() - 3))) {
					return true;
				}
			} else if (requestUri.startsWith(url)) {
				return true;
			}
		}

		retUrl = StringUtils.isBlank(retUrl) ? "" : URLEncoder.encode(retUrl, "UTF-8");
		// 其他需要登录后才能进行访问的url		
		// 如果没有登录
		if (SysUtils.isEmpty(user)) {
			// 是否为ajax请求
			if (SysUtils.isAjaxRequest(request)) {
				response.setHeader("SESSIONSTATUS", "TIMEOUT");
				response.setHeader("CONTEXTPATH", "/user/toCodeLogin?backurl=" + retUrl);
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);// 403 禁止
			} else {
				// 返回到登录页面
				// request.getRequestDispatcher("/user/toCodeLogin").forward(request,
				// response);
				response.sendRedirect("/open/toLogin?backurl=" + retUrl);
			}
			return false;
		} else {
			return true;
		}

	}

}
