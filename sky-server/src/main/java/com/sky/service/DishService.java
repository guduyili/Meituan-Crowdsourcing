package com.sky.service;

import com.sky.dto.DishDTO;
import org.springframework.stereotype.Service;

/***
 *@title DishService
 *@description <TODO description class purpose>
 *@author lzy33
 *@version 1.0.0
 *@create 21/11/2024 下午 4:04
 **/
@Service
public interface DishService {


    /**
     * 新增菜品的对应口味
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);
}
