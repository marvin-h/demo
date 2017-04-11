package com.demo.mybatis.typehandler;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where id=#{id}")
    UserEntity selectUser(int id);

    @Select("select * from user where name=#{name}")
    UserEntity selectUserByName(String name);
}