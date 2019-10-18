package com.qst.Bean;

/**
 * @author LiuYunDa
 * @date 2019/10/18 - 15:55]
 * 福利保险类
 */
public class insInfo {
    private Integer insId;
    private String insName;
    private Double insPrice;
//    private Integer userId;



    public Double getInsPrice() {
        return insPrice;
    }

    public void setInsPrice(Double insPrice) {
        this.insPrice = insPrice;
    }

    public Integer getInsId() {
        return insId;
    }

    public void setInsId(Integer insId) {
        this.insId = insId;
    }

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }
}
