package com.taotao.manager.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.manager.entity.TbItem;
import com.taotao.manager.repository.TbItemRepository;
import com.taotao.manager.service.ItemService;

@Service("itemService")
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemRepository itemRepsoitory;

	@Override
	public TbItem getItemById(long id) {
		TbItem tbItem = itemRepsoitory.findOne(id);
		return tbItem;
	}

	@Override
	public EasyUIDataGridResult<TbItem> getItemList(int pageNum, int pageSize) {
		Pageable pageable = new PageRequest((pageNum-1)*pageSize, pageSize);
		Page<TbItem> page = itemRepsoitory.findAll(pageable);
		EasyUIDataGridResult<TbItem> result = new EasyUIDataGridResult<TbItem>();
		result.setRows(page.getContent());
		result.setTotal(page.getTotalElements());
		return result;
	}

}
