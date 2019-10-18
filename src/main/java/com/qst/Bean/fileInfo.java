package com.qst.Bean;

import java.util.List;

/**
 * @author LiuYunDa
 * @date 2019/10/18 - 9:50
 */
public class fileInfo {
    private Integer fileId;
    private Integer userId;
    private String userName;
    private String laodongFile;//劳动合同存储地址
    private String peixunFile;//培训合同存储地址
    private String baomiFile;//保密协议存储地址




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getLaodongFile() {
        return laodongFile;
    }

    public void setLaodongFile(String laodongFile) {
        this.laodongFile = laodongFile;
    }

    public String getPeixunFile() {
        return peixunFile;
    }

    public void setPeixunFile(String peixunFile) {
        this.peixunFile = peixunFile;
    }

    public String getBaomiFile() {
        return baomiFile;
    }

    public void setBaomiFile(String baomiFile) {
        this.baomiFile = baomiFile;
    }
}
