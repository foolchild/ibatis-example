package com.ibatis.example.vo;

import com.ibatis.example.entity.BaseEntity;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Data
public class UserVO extends BaseEntity {

    private Long id;

    private String name;

    private String type;

    private String phone;

    private String email;

    private String male;
}
