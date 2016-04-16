package com.hzih.compare.domain;

import java.util.Date;

/**
 * Created by Administrator on 16-3-24.
 */
public class IdentityQueryLog {
    long id;
    String session_id;
    String id_card;
    String code;
    String xq;
    Date log_time;

    public IdentityQueryLog() {
    }

    public IdentityQueryLog(String session_id, String id_card, String code, String xq, Date log_time) {
        this.session_id = session_id;
        this.id_card = id_card;
        this.code = code;
        this.xq = xq;
        this.log_time = log_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
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

    public Date getLog_time() {
        return log_time;
    }

    public void setLog_time(Date log_time) {
        this.log_time = log_time;
    }
}
