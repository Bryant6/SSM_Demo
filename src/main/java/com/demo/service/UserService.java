package com.demo.service;

import com.demo.domain.User;

import java.util.List;

public interface UserService {

    //查询所有
    public List<User> findAll();

    //保存用户
    void save(User user);
}
