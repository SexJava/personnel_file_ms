package com.qst.Bean;

/**
 * @author LiuYunDa
 * @date 2019/10/8 - 14:54
 */
public class admInfo {
    private Integer admId;
    private String admName;
    private String admPwd;
    private Integer admRole;

    @Override
    public String toString() {
        return "admInfo{" +
                "admId=" + admId +
                ", admName='" + admName + '\'' +
                ", admPwd='" + admPwd + '\'' +
                ", admRole=" + admRole +
                '}';
    }

    public Integer getAdmId() {
        return admId;
    }

    public void setAdmId(Integer admId) {
        this.admId = admId;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getAdmPwd() {
        return admPwd;
    }

    public void setAdmPwd(String admPwd) {
        this.admPwd = admPwd;
    }

    public Integer getAdmRole() {
        return admRole;
    }

    public void setAdmRole(Integer admRole) {
        this.admRole = admRole;
    }
}
