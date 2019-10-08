package com.qst.Mapper;

import com.qst.Bean.userInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author LiuYunDa
 * @date 2019/10/8 - 15:15
 */
@Mapper
public interface userMapper {
    @Select("select * from userInfo where userName=#{name} and userPwd = #{pwd}")
    userInfo userLogin(@Param("name") String name, @Param("pwd") String pwd);
}
