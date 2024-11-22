package com.sky.mapper;

import com.sky.entity.DishFlavor;
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

    void insertBatch(List<DishFlavor> flavors);
}
