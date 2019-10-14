package com.ibatis.example.controller;

import com.ibatis.example.entity.UserEntity;
import com.ibatis.example.service.UserService;
import com.ibatis.example.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/query", method = RequestMethod.POST)
    public ResponseEntity query(@RequestBody UserEntity user) {

        return new ResponseEntity(userService.queryUser(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    public ResponseEntity list(@RequestBody UserVO user) {

        return new ResponseEntity(userService.findUser(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/like", method = RequestMethod.POST)
    public ResponseEntity like(@RequestBody UserEntity user) {

        return new ResponseEntity(userService.findUserExample(user), HttpStatus.OK);
    }
}
