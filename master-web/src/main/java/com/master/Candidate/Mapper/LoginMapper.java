package com.master.Candidate.Mapper;

import com.master.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface LoginMapper {


    //查找是否有该求职者的账户
    @Select("select * from user where phone = #{phone}")
    User userLogin(String phone);
}
