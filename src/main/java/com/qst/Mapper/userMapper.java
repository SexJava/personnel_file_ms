package com.qst.Mapper;

import com.qst.Bean.userInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author LiuYunDa
 * @date 2019/10/8 - 15:15
 */
@Mapper
public interface userMapper {
    @Select("select * from userInfo where userName=#{name} and userPwd = #{pwd}")
    userInfo userLogin(@Param("name") String name, @Param("pwd") String pwd);
    @Insert("insert into userInfo (userName,userPwd,userRole) values (#{name},#{pwd},#{role})")
    int userAdd(@Param("name") String name, @Param("pwd") String pwd, @Param("role") int role);
    @Select("select * from userInfo")
    List<userInfo> findAll();
    @Select("select * from userInfo where userId = #{userId}")
    userInfo findUserById(@Param("userId") Integer userId);
    //修改用户信息
    @Update("update userInfo set userName = #{userName},userPwd = #{userPwd} where userId = #{userId}")
    int updateUser(@Param("userId") Integer userId,@Param("userName") String userName,@Param("userPwd") String userPwd);
    @Delete("delete from userInfo where userId = #{userId}")
    int delUser(@Param("userId") Integer userId);
    //修改薪资信息
    @Update("update userInfo set userSal = #{userSal} where userId = #{userId}")
    int updateUserSal(@Param("userId") Integer userId,@Param("userSal") Double userSal);


}
