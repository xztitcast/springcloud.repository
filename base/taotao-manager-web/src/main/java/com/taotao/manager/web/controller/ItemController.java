package com.taotao.manager.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.manager.entity.TbItem;
import com.taotao.manager.web.feign.ItemFeignClient;

/**
 * 商品控制器
 * @author xiangzuotao
 * @date 2018年1月27日 下午4:58:13
 * @version
 */
@RestController
public class ItemController {
	
	@Autowired
	private ItemFeignClient itemFeignClient;

	/**
	 * 根据id获取商品信息
	 * @param itemId
	 * @return
	 */
	@GetMapping("/item/{itemId}")
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemFeignClient.getItemById(itemId);
		return tbItem;
	}
	
	@GetMapping("/item/list")
	public EasyUIDataGridResult<TbItem> getItemList(@RequestParam(value = "page", defaultValue = "1")Integer page, 
			@RequestParam(value = "rows", defaultValue = "20")Integer rows){
		EasyUIDataGridResult<TbItem> result = itemFeignClient.getItemList(page, rows);
		return result;
	}
}
