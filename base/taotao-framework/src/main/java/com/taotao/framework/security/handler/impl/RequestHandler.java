package com.taotao.framework.security.handler.impl;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.taotao.framework.security.handler.SecurityHandler;

@Component
@Scope("prototype")
public class RequestHandler implements SecurityHandler {

	@Override
	public boolean assertAuthorize(String appKey) {
		//此处应该是去缓存中获取token或者认证证书比对 暂时案例没用缓存或证书 适当判断下
		if(appKey == null || appKey.trim().length() ==0) {
			return false;
		}
		System.out.println(appKey);
		return true;
	}

}
