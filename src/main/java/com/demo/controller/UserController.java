package com.demo.controller;

import com.demo.domain.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("controller层：查询所有账户。。。");

        List<User> list = userService.findAll();
        for (User u:list){
            System.out.println(u.toString());
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");

        return mv;
    }

    @RequestMapping("/save")
    public String save(User user){
        System.out.println("controller层：保存账户。。。");

        userService.save(user);

        return "success";
    }
}

