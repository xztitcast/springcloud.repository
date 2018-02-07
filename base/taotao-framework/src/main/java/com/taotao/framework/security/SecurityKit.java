package com.taotao.framework.security;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.taotao.framework.security.handler.SecurityHandler;

public abstract class SecurityKit {

	private static Map<Method, SecurityHandler> cacheMap ;
	
	static {
		cacheMap = new ConcurrentHashMap<>();
	}
	
	public static void put(Method method, SecurityHandler handler) {
		cacheMap.put(method, handler);
	}
	
	public static SecurityHandler get(Method method) {
		return cacheMap.get(method);
	}
	
	public static SecurityHandler remove(Method method) {
		SecurityHandler handler = null;
		if(cacheMap.containsKey(method)) {
			handler = cacheMap.remove(method);
		}
		return handler;
	}
}
