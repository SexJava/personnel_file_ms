package com.qst.Bean;

/**
 * @author LiuYunDa
 * @date 2019/10/8 - 14:55
 */
public class userInfo {
    private Integer userId;
    private String userName;
    private String userPwd;
    private Integer userRole;
    private Double userSal;

    public Double getUserSal() {
        return userSal;
    }

    public void setUserSal(Double userSal) {
        this.userSal = userSal;
    }

    @Override
    public String toString() {
        return "userInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userRole=" + userRole +
                '}';
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

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
}
