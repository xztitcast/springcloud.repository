package com.taotao.framework.security;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.common.utils.SpringAppContextUtil;
import com.taotao.framework.annotaion.RequestAuthz;
import com.taotao.framework.security.handler.impl.RequestHandler;

@Component
public class SecurityScanner implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		SpringAppContextUtil.setApplicationContext(context);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null) {
			Map<String, Object> beanMap = context.getBeansWithAnnotation(RestController.class);
			if(beanMap == null || beanMap.isEmpty()) {
				return;
			}
			beanMap.values().forEach(
					bean -> {
						Class<?> cls = bean.getClass();
						if(cls.getAnnotation(RestController.class) == null) {
							cls = bean.getClass().getSuperclass();
						}
						RequestAuthz clsAnnotaion = cls.getAnnotation(RequestAuthz.class);
						Method[] methods = cls.getMethods();
						for(Method method : methods) {
							if(Modifier.isPrivate(method.getModifiers())) {
								continue;
							}
							if(clsAnnotaion != null) {
								SecurityKit.put(method, SpringAppContextUtil.getBean(RequestHandler.class));
								continue;
							}
							RequestAuthz methodAnnotation = method.getAnnotation(RequestAuthz.class);
							if(methodAnnotation != null) {
								SecurityKit.put(method, SpringAppContextUtil.getBean(RequestHandler.class));
							}
						}
					}
			);
			
		}
	}

}
