package com.taotao.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taotao.manager.entity.TbItemDesc;

/**
 * 商品描述持久层
 * @author xiangzuotao
 * @date 2018年1月27日 下午4:24:35
 * @version
 */
public interface TbItemDescRepository extends JpaRepository<TbItemDesc, Long> {

}
