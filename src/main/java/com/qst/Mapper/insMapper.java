package com.qst.Mapper;

import com.qst.Bean.insInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author LiuYunDa
 * @date 2019/10/18 - 16:05
 */

@Mapper
public interface insMapper {
    @Select("select * from insInfo")
    List<insInfo> findAllInsInfo();
    @Select("select * from insInfo where insId = #{insId}")
    insInfo findInsInfoById(@Param("insId")Integer insId);
    @Insert("insert into insInfo(insId,insName,insPrice) values(#{insId},#{insName},#{insPrice})")
    int addInsInfo(@Param("insId") Integer insId,@Param("insName") String insName,@Param("insPrice")Double insPrice);
//    @Update("update insInfo set userId = #{userId} where insId = #{insId} and insName = #{insName} ")
//    int insForUser(@Param("insId")Integer insId,@Param("insName")String insName,@Param("userId")Integer userId);
//投保
    @Update("update userInfo set insId =#{insId} where userId=#{userId}")
    int InsForUser(@Param("userId")Integer userId,@Param("insId")Integer insId);
}
