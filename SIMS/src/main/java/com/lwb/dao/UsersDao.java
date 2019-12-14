package com.lwb.dao;

import com.lwb.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UsersDao {



        @Select("select * from user where u_id = #{uid} and u_pwd = #{upwd}")
        Users findUser(@Param(value = "uid") String uid, @Param(value = "upwd") String upwd);
}
