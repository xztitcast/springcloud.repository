package com.taotao.manager.service.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.manager.entity.TbItem;
import com.taotao.manager.service.ItemService;

/**
 * 商品请求映射
 * @author xiangzuotao
 * @date 2018年1月27日 下午5:04:21
 * @version
 */
@RestController
@RequestMapping("/manager-mapping")
public class ItemRequestMapping {
	
	@Autowired
	private ItemService itemService;

	/**
	 * 根据商品id获取商品
	 * @param id
	 * @return
	 */
	@GetMapping("/item/{id}")
	public TbItem getItemById(@PathVariable Long id) {
		TbItem tbItem = itemService.getItemById(id);
		return tbItem;
	}
	
	@GetMapping("/item/list/{page}/{rows}")
	public EasyUIDataGridResult<TbItem> getItemList(@PathVariable Integer page, @PathVariable Integer rows) {
		EasyUIDataGridResult<TbItem> result = itemService.getItemList(page, rows);
		return result;
	}
}
