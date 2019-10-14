package com.ibatis.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.ibatis.example.entity.UserEntity;
import com.ibatis.example.mapper.UserMapper;
import com.ibatis.example.vo.UserVO;
import org.springframework.stereotype.Service;
import com.ibatis.example.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    ObjectMapper objectMapper;

    @Override
    public UserEntity queryUser(UserEntity user) {

        Example example = new Example(UserEntity.class);

        Example.Criteria criteria = example.createCriteria();
        UserEntity condition = new UserEntity();
        condition.setName("zhang");
        example.equals(condition);
        PageHelper.startPage(1,2);
        return userMapper.selectOne(condition);
    }

    @Override
    public List<UserEntity> findUser(UserVO user) {
        if (user.getPageNumber() != null && user.getPageSize() != null) {
            PageHelper.startPage(user.getPageNumber().intValue() ,user.getPageSize().intValue());
        }

        UserEntity condition = new UserEntity();
        try {
            condition = objectMapper.readValue(objectMapper.writeValueAsString(user), UserEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userMapper.select(condition);
    }

    public List<UserEntity> findUserExample(UserEntity userEntity) {
        Example example = new Example(UserEntity.class);

        Example.Criteria criteria = example.createCriteria();

        criteria.andLike("name", "zhang%");

        return userMapper.selectByExample(example);
    }
}
