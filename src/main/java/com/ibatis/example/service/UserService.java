package com.ibatis.example.service;

import com.ibatis.example.entity.UserEntity;
import com.ibatis.example.vo.UserVO;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    UserEntity queryUser(UserEntity user);

    List<UserEntity> findUser(UserVO userEntity);

    List<UserEntity> findUserExample(UserEntity user);
}
