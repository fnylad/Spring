package com.master.HR.Mapper;

import com.master.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HrLoginMapper {

    @Select("select * from user where phone=#{phone}")
    User HrLogin(String phone);
}
