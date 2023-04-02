package com.master.Candidate.ServiceImpl;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.master.Candidate.Mapper.LoginMapper;
import com.master.Candidate.Service.LoginService;
import com.master.Entity.User;
import com.master.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public String candidateLogin(String phone, String password) throws JacksonException {
        User user =loginMapper.userLogin(phone);
        if(user != null){
            if(password.equals(user.getPassword())){
                String token = TokenUtil.sign(user);
               HashMap<String,Object> hs =new  HashMap<>();
               hs.put("token",token);
               ObjectMapper objectMapper=new ObjectMapper();
               return objectMapper.writeValueAsString(hs);
            }else {
                return "账号或密码错误";
            }
        }else{
            return "用户不存在";
        }

    }
}
