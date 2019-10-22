package com.qst.Mapper;

import com.qst.Bean.comInfo;
import com.qst.Bean.rencaiInfo;
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
    //添加招聘公司
    @Insert("insert into comInfo values (null,#{comName})")
    int addComInfo(@Param("comName") String comName);
    //查询招聘公司
    @Select("select * from comInfo")
    List<comInfo> findAllComInfo();
    //连接查询人才库
    @Select("select rencaiInfo.userId,rencaiInfo.userName,comInfo.comId,comInfo.comName from rencaiInfo inner join comInfo on rencaiInfo.comId = comInfo.comId")
    List<rencaiInfo> findAllRencaiInfo();
}
