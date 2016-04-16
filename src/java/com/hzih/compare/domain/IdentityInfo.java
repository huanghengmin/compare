package com.hzih.compare.domain;

import java.util.Date;

/**
 * 帐号，用户
 * 
 * @author collin.code@gmail.com
 * @hibernate.class table="account"
 */
public class IdentityInfo {
    private String idCard;
    private int status;
    private String code;
    private String xq;
    private Date compare_time;

    public IdentityInfo(String idCard) {
        this.idCard = idCard;
    }

    public IdentityInfo() {
    }

    public IdentityInfo(String idCard, int status, String code, String xq, Date compare_time) {
        this.idCard = idCard;
        this.status = status;
        this.code = code;
        this.xq = xq;
        this.compare_time = compare_time;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public Date getCompare_time() {
        return compare_time;
    }

    public void setCompare_time(Date compare_time) {
        this.compare_time = compare_time;
    }
}
