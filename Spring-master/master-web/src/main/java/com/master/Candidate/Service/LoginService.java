package com.master.Candidate.Service;


import com.fasterxml.jackson.core.JacksonException;

public interface LoginService {
    //求职者登录

    String candidateLogin(String phone,String passwd) throws JacksonException;



}
