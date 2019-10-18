package com.qst.Mapper;

import com.qst.Bean.comInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiuYunDa
 * @date 2019/10/17 - 15:29
 */
@Mapper
public interface comMapper {
    @Insert("insert into comInfo values (null,#{comName})")
    int addComInfo(@Param("comName") String comName);
    @Select("select * from comInfo")
    List<comInfo> findAllComInfo();
}
