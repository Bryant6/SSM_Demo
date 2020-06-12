package com.demo.mapper;

import com.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select(value = "select * from user")
    public List<User> findAll();

    @Insert(value = "insert into user(username,password) values(#{username},#{username})")
    void save(User user);
}
