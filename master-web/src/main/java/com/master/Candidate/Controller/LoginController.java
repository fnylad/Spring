package com.master.Candidate.Controller;


import com.master.Candidate.Mapper.UserMapper;
import com.master.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/hello")
    public String hello(){
        return "hekki";
    }


    @GetMapping("/login/{phone}")
    public List<User> login(@PathVariable("phone") String phone){
        List<User> users =userMapper.queryUserByPhone(phone);

        return users;
    }
}
