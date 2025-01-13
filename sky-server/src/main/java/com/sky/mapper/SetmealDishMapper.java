package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/***
 *@title SetmealDishMapper
 *@description <TODO description class purpose>
 *@author lzy33
 *@version 1.0.0
 *@create 23/11/2024 下午 5:21
 **/
@Mapper
public interface SetmealDishMapper {
    //select setmeal id from setmeal dish where dish_id in (1,2,3,4)
    /**
     * 判断当前菜品是否被套餐关联了
     * @param ids
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> ids);
}
