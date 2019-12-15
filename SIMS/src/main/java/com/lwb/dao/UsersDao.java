package com.lwb.dao;

import com.lwb.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UsersDao {


        /**
         * 登录验证
         * @param uid
         * @param upwd
         * @return
         */
        @Select("select * from user where u_id = #{uid} and u_pwd = #{upwd}")
        Users findUser(@Param(value = "uid") String uid, @Param(value = "upwd") String upwd);

        @Update("update user set u_pwd = #{newpwd} where u_id = #{uid}")
        Integer changePwd(@Param(value = "uid") String uid, @Param(value = "newpwd") String newpwd);

        /**
         * 根据id获取密码
         * @param unum
         * @return
         */
        @Select("select u_pwd from user where u_id =#{unum}")
        String getpwd(String unum);
}
