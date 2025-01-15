package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/***
 *@title ShoppingCartMapper
 *@description <TODO description class purpose>
 *@author lzy33
 *@version 1.0.0
 *@create 14/1/2025 下午 6:18
 **/
@Mapper
public interface ShoppingCartMapper {

    /**
     * 条件查询
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 更新商品数量
     * @param shoppingCart
     */
    void updateNumberById(ShoppingCart shoppingCart);

    /**
     * 插入购物车数据
     * @param shoppingCart
     */
    void insert(ShoppingCart shoppingCart);

    void deleteById(Long id);

    void deleteByUserId(Long currentId);
}
