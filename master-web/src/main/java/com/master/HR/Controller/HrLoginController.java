package com.master.HR.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.master.HR.Mapper.HrLoginMapper;
import com.master.HR.Service.HrLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HrLoginController {

    @Autowired
    private HrLoginService hrLoginService;

    @RequestMapping("/premise/hr_login")
    @ResponseBody
    public String hrLogin(@RequestBody Map<String , Map> para) throws JsonProcessingException {
        String phone = para.get("data").get("phone").toString();
        String password = para.get("data").get("password").toString();
        String state = hrLoginService.HrLogin(phone,password);
        return state;
    }
}
