package com.qst.Mapper;

import com.qst.Bean.admInfo;
import com.qst.Bean.userInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author LiuYunDa
 * @date 2019/10/8 - 14:58
 */
@Mapper
public interface admMapper {
    @Select("select * from admInfo where admName=#{name} and admPwd = #{pwd}")
    admInfo admLogin(@Param("name") String name,@Param("pwd") String pwd);
    @Insert("insert into admInfo values (null,#{name},#{pwd},#{role})")
    int admAdd(@Param("name") String name,@Param("pwd") String pwd,@Param("role") int role);

}
