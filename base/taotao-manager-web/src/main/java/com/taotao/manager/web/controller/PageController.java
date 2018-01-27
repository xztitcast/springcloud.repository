package com.taotao.manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 页面控制器
 * @author xiangzuotao
 * @date 2018年1月27日 下午4:44:15
 * @version
 */
@Controller
public class PageController {

	/**
	 * 展示首页
	 * @return
	 */
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	/**
	 * 返回当前页
	 * @param page
	 * @return
	 */
	@GetMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
