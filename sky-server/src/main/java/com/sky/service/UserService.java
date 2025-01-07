package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/***
 *@title UserService
 *@description <TODO description class purpose>
 *@author lzy33
 *@version 1.0.0
 *@create 5/1/2025 下午 3:14
 **/

public interface UserService {
    User wxLogin(UserLoginDTO userLoginDTO);
}
