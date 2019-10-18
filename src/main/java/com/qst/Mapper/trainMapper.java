package com.qst.Mapper;


import com.qst.Bean.trainInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiuYunDa
 * @date 2019/10/17 - 16:12
 */
@Mapper
public interface trainMapper {
    @Insert("insert into trainInfo values (null,#{trainName})")
    int addTrainInfo(@Param("trainName") String trainName);
    @Select("select * from trainInfo")
    List<trainInfo> findAllTrainInfo();

}
