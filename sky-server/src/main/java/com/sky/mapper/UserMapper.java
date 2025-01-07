package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/***
 *@title UserMapper
 *@description <TODO description class purpose>
 *@author lzy33
 *@version 1.0.0
 *@create 5/1/2025 下午 3:41
 **/
@Mapper
public interface UserMapper {

    @Select("select * from user where  openid = #{openid}")
    User getByOpenid(String openid);


    void insert(User user);
}
