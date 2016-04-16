package com.hzih.compare.web.action.compare;

import cn.collin.commons.domain.PageResult;
import com.hzih.compare.dao.IdentityQueryLogDao;
import com.hzih.compare.domain.IdentityQueryLog;
import com.hzih.compare.web.action.ActionBase;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 16-4-6.
 */
public class IdentityQueryLogAction extends ActionSupport {
    private IdentityQueryLogDao identityQueryLogDao;

    public IdentityQueryLogDao getIdentityQueryLogDao() {
        return identityQueryLogDao;
    }

    public void setIdentityQueryLogDao(IdentityQueryLogDao identityQueryLogDao) {
        this.identityQueryLogDao = identityQueryLogDao;
    }
    private int start;
    private int limit;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String find() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        ActionBase actionBase = new ActionBase();
        String result =	actionBase.actionBegin(request);
        String idCard = request.getParameter("idCard");
        String json = null;
        PageResult pageResult = identityQueryLogDao.listByPage(idCard, start/limit+1,limit);
        if (pageResult != null) {
            List<IdentityQueryLog> companyList = pageResult.getResults();
            int count = pageResult.getAllResultsAmount();
            if (companyList != null) {
                json = build(companyList, count);
            }
        }

        actionBase.actionEnd(response,json,result);
        return null;
    }

    private String build(List<IdentityQueryLog> districts, int count) {
        StringBuilder json = new StringBuilder("{total:" + count + ",rows:[");
        Iterator<IdentityQueryLog> iterator = districts.iterator();
        while (iterator.hasNext()) {
            IdentityQueryLog company = iterator.next();
            if (iterator.hasNext()) {
                json.append("{");
                json.append("id:'" + company.getId() + "',");
                json.append("idCard:'" + company.getId_card() + "',");
                json.append("session_id:'" + company.getSession_id() + "',");
                json.append("code:'" + company.getCode() + "',");
                json.append("xq:'" + company.getXq() + "',");
                json.append("log_time:'" + company.getLog_time() + "'");
                json.append("},");
            } else {
                json.append("{");
                json.append("id:'" + company.getId() + "',");
                json.append("idCard:'" + company.getId_card() + "',");
                json.append("session_id:'" + company.getSession_id() + "',");
                json.append("code:'" + company.getCode() + "',");
                json.append("xq:'" + company.getXq() + "',");
                json.append("log_time:'" + company.getLog_time() + "'");
                json.append("}");
            }
        }
        json.append("]}");
        return json.toString();
    }
}
