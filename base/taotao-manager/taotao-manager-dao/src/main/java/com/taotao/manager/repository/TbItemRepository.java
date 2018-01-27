package com.taotao.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taotao.manager.entity.TbItem;

/**
 * 商品持久层
 * @author xiangzuotao
 * @date 2018年1月27日 下午4:23:48
 * @version
 */
public interface TbItemRepository extends JpaRepository<TbItem, Long> {

}
