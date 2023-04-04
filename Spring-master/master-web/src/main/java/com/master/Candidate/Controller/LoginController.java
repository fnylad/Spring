package com.master.Candidate.Controller;


import com.fasterxml.jackson.core.JacksonException;
import com.master.Candidate.Service.LoginService;
import com.master.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private  LoginService loginService;


    @RequestMapping("/premise/candidate_login")
    @ResponseBody
    public String applyLogin(@RequestBody Map<String, Map> para) throws JacksonException {
        String phone = para.get("data").get("phone").toString();
        String password = para.get("data").get("password").toString();
        String state=loginService.candidateLogin(phone,password);
        return state;

    }
}
