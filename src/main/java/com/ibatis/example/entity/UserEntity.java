package com.ibatis.example.entity;

import lombok.Data;

@Data
public class UserEntity{

    private Long id;

    private String name;

    private String type;

    private String phone;

    private String email;

    private String male;
}
