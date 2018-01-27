package com.taotao.manager.web.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.manager.entity.TbItem;
import com.taotao.manager.web.feign.ItemFeignClient.ItemHystrixClientFallback;

@FeignClient(name = "taotao-manager", fallback = ItemHystrixClientFallback.class)
public interface ItemFeignClient {

	/**
	 * 断路器
	 * @author xiangzuotao
	 * @date 2018年1月27日 下午4:54:02
	 * @version
	 */
	@Component
	static class ItemHystrixClientFallback implements ItemFeignClient {

		@Override
		public TbItem getItemById(Long id) {
			TbItem tbItem = new TbItem();
			tbItem.setId(id);
			tbItem.setTitle("断路器启动");
			return null;
		}

		@Override
		public EasyUIDataGridResult<TbItem> getItemList(Integer page, Integer rows) {
			return null;
		}
		
	}
	
	/**
	 * 根据id查询商品信息
	 * @param id
	 * @return
	 */
	@GetMapping("/manager-mapping/item/{id}")
	public TbItem getItemById(@PathVariable("id") Long id);

	/**
	 * 获取商品列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/manager-mapping/item/list/{page}/{rows}")
	public EasyUIDataGridResult<TbItem> getItemList(@PathVariable("page") Integer page, @PathVariable("rows") Integer rows);
}
