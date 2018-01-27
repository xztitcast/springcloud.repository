package com.taotao.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taotao.manager.entity.TbItemCat;

/**
 * 商品类目持久层
 * @author xiangzuotao
 * @date 2018年1月27日 下午4:25:20
 * @version
 */
public interface TbItemCatRepository extends JpaRepository<TbItemCat, Long> {

}
