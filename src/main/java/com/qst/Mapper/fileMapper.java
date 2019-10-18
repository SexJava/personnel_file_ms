package com.qst.Mapper;


import com.qst.Bean.fileInfo;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @author LiuYunDa
 * @date 2019/10/18 - 10:02
 */

@Mapper
public interface fileMapper {
    @Insert("insert into fileInfo values (null,#{userId},#{laodongFile},#{peixunFile},#{baomiFile})")
    int addFileInfo(@Param("userId")Integer userId,@Param("laodongFile") String laodongFile,@Param("peixunFile") String peixunFile,@Param("baomiFile") String baomiFile);
    @Select("select fileInfo.userId,userInfo.userName,fileInfo.laodongFile,fileInfo.peixunFile,fileInfo.baomiFile,fileInfo.fileId from fileInfo inner join userInfo on fileInfo.userId = userInfo.userId")
    List<fileInfo> findAllFileInfo();
    @Update("update fileInfo set laodongFile = #{laodongFile},peixunFile = #{peixunFile} ,baomiFile =#{baomiFile} where fileId = #{fileId}")
    int updateFileInfo(@Param("fileId") Integer fileId,@Param("laodongFile") String laodongFile,@Param("peixunFile") String peixunFile,@Param("baomiFile")String baomiFile);
    @Select("select * from fileInfo where userId = #{userId}")
    fileInfo findUserFileInfo(Integer userId);
}
