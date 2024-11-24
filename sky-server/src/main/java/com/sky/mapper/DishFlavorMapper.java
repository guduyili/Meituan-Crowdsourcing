package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/***
 *@title DishFlavorMapper
 *@description <TODO description class purpose>
 *@author lzy33
 *@version 1.0.0
 *@create 21/11/2024 下午 10:14
 **/

@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除对应的口味数据
     * @param dishId
     */
    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);


    /**
     * 根据菜品id集合批量删除关联的口味数据
     * @param dishids
     */
    void deleteByDishIds(List<Long> dishids);
}
