package com.taotao.framework.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.framework.security.SecurityKit;
import com.taotao.framework.security.handler.SecurityHandler;

public class RequestInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest reqeust, HttpServletResponse request, Object handler) throws Exception {
		String appKey = reqeust.getHeader("appKey"); 
		if(StringUtils.isBlank(appKey)) {
			appKey = reqeust.getParameter("appKey");
		}
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Method method  = handlerMethod.getMethod();
		SecurityHandler securityHandler = SecurityKit.get(method);
		return securityHandler.assertAuthorize(appKey);
	}

}
