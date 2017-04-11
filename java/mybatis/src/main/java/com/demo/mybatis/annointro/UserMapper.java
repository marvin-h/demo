package com.demo.mybatis.annointro;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where id=#{id}")
    UserEntity selectUser(int id);
}