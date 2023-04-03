package com.master.HR.Service;


import com.fasterxml.jackson.core.JsonProcessingException;

public interface HrLoginService {

    //求职者登录
    String HrLogin(String phone,String password) throws JsonProcessingException;
}
