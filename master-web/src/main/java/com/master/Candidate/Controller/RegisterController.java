package com.master.Candidate.Controller;

import com.master.Candidate.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class RegisterController {


    @Autowired
    private RegisterService registerService;

    @RequestMapping("/premise/candidate_register/step_1")
    @ResponseBody
    public Integer candidateRegister(@RequestBody Map <String, Map> para){
        String phone = para.get("data").get("phone").toString();
        String password = para.get("data").get("password").toString();
        return  registerService.candidateRegister(phone,password);
    }

    @RequestMapping("/premise/candidate_register/step_2")
    @ResponseBody
    public Integer updateUserBase(@RequestBody Map<String ,Map> para) throws ParseException {
        String phone =para.get("data").get("phone").toString();
        String name =para.get("data").get("name").toString();
        Integer sex = Integer.valueOf(para.get("data").get("sex").toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday =para.get("data").get("birthday").toString();
        Date date =simpleDateFormat.parse(birthday);
        return registerService.perfectCandidateInfo(phone,name,sex,date);

    }
}
