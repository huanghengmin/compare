package com.hzih.compare.web.action.compare;

import cn.collin.commons.domain.PageResult;
import com.hzih.compare.dao.IdentityInfoDao;
import com.hzih.compare.dao.IdentityQueryLogDao;
import com.hzih.compare.domain.IdentityInfo;
import com.hzih.compare.domain.IdentityQueryLog;
import com.hzih.compare.web.action.ActionBase;
import com.opensymphony.xwork2.ActionSupport;
import com.zjipst.icnr.service.CheckResult;
import com.zjipst.icnr.service.PersonCheckProxy;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 16-4-6.
 */
public class IdentityInfoAction extends ActionSupport {
    private Logger logger = Logger.getLogger(IdentityInfoAction.class);
    private IdentityInfoDao identityInfoDao;
    private IdentityQueryLogDao identityQueryLogDao;
    private IdentityInfo identityInfo;

    public IdentityInfo getIdentityInfo() {
        return identityInfo;
    }

    public void setIdentityInfo(IdentityInfo identityInfo) {
        this.identityInfo = identityInfo;
    }

    public IdentityInfoDao getIdentityInfoDao() {
        return identityInfoDao;
    }

    public void setIdentityInfoDao(IdentityInfoDao identityInfoDao) {
        this.identityInfoDao = identityInfoDao;
    }


    public IdentityQueryLogDao getIdentityQueryLogDao() {
        return identityQueryLogDao;
    }

    public void setIdentityQueryLogDao(IdentityQueryLogDao identityQueryLogDao) {
        this.identityQueryLogDao = identityQueryLogDao;
    }

    private int start;
    private int limit;

    public String find() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        ActionBase actionBase = new ActionBase();
        String result = actionBase.actionBegin(request);
        String idCard = request.getParameter("idCard");
        String json = null;
        PageResult pageResult = identityInfoDao.listByPage(idCard, start / limit + 1, limit);
        if (pageResult != null) {
            List<IdentityInfo> companyList = pageResult.getResults();
            int count = pageResult.getAllResultsAmount();
            if (companyList != null) {
                json = build(companyList, count);
            }
        }
        actionBase.actionEnd(response, json, result);
        return null;
    }

    public String save() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        ActionBase actionBase = new ActionBase();
        String result = actionBase.actionBegin(request);
        String json = null;
        String msg = null;
        try {
            PersonCheckProxy p = new PersonCheckProxy();
            String sessionId = System.currentTimeMillis() + "";
            CheckResult r = p.check(sessionId, identityInfo.getIdCard(), "", "");
            logger.info(r.getCode() + "|" + r.getSessionId() + "|" + "" + r.getXq());
            IdentityInfo info = new IdentityInfo();
            info.setCode(r.getCode());
            info.setXq(r.getXq());
            info.setCompare_time(new Date());
            info.setStatus(1);
            identityInfoDao.save(info);
            identityQueryLogDao.save(new IdentityQueryLog(r.getSessionId(), info.getIdCard(), r.getCode(), r.getXq(), new Date()));
            msg = "保存对比成功" + identityInfo.getIdCard();
            json = "{success:true,msg:'" + msg + "'}";
        } catch (Exception e) {
            try {
                identityInfoDao.save(identityInfo);
                msg = "保存对比成功" + identityInfo.getIdCard();
                json = "{success:true,msg:'" + msg + "'}";
            } catch (Exception ex) {
                msg = "保存对比失败" + identityInfo.getIdCard();
                json = "{success:false,msg:'" + msg + "'}";
            }
        }
        actionBase.actionEnd(response, json, result);
        return null;
    }

    private String build(List<IdentityInfo> districts, int count) {
        StringBuilder json = new StringBuilder("{total:" + count + ",rows:[");
        Iterator<IdentityInfo> iterator = districts.iterator();
        while (iterator.hasNext()) {
            IdentityInfo company = iterator.next();
            if (iterator.hasNext()) {
                json.append("{");
                json.append("idCard:'" + company.getIdCard() + "',");
                json.append("code:'" + company.getCode() + "',");
                json.append("xq:'" + company.getXq() + "',");
                json.append("status:'" + company.getStatus() + "',");
                json.append("compare_time:'" + company.getCompare_time() + "'");
                json.append("},");
            } else {
                json.append("{");
                json.append("idCard:'" + company.getIdCard() + "',");
                json.append("code:'" + company.getCode() + "',");
                json.append("xq:'" + company.getXq() + "',");
                json.append("status:'" + company.getStatus() + "',");
                json.append("compare_time:'" + company.getCompare_time() + "'");
                json.append("}");
            }
        }
        json.append("]}");
        return json.toString();
    }

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
}
