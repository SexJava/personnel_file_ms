package com.qst.Bean;

/**
 * @author LiuYunDa
 * @date 2019/10/22 - 22:52
 */
public class rencaiInfo {
    private Integer userId;
    private String userName;
    private Integer comId;
    private String comName;

    @Override
    public String toString() {
        return "rencaiInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", comId=" + comId +
                ", comName='" + comName + '\'' +
                '}';
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }
}
