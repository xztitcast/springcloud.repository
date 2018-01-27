package com.taotao.manager.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.manager.entity.TbItem;

/**
 * 商品服务
 * @author xiangzuotao
 * @date 2018年1月27日 下午5:01:06
 * @version
 */
public interface ItemService {

	/**
	 * 根据id个获取商品
	 * @param id
	 * @return
	 */
	public TbItem getItemById(long id);

	/**
	 * 获取商品列表
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public EasyUIDataGridResult<TbItem> getItemList(int pageNum, int pageSize);
}
