package com.cx.webservice;


import com.hzih.compare.dao.IdentityInfoDao;
import com.hzih.compare.dao.IdentityQueryLogDao;
import com.hzih.compare.domain.IdentityInfo;
import com.hzih.compare.domain.IdentityQueryLog;
import com.zjipst.icnr.service.CheckResult;
import com.zjipst.icnr.service.PersonCheckProxy;
import org.apache.log4j.Logger;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by Administrator on 16-3-30.
 */
@WebService
public class FindService {
    private Logger logger = Logger.getLogger(FindService.class);
    private IdentityInfoDao identityInfoDao;
    private IdentityQueryLogDao identityQueryLogDao;

    @WebMethod(exclude = true)
    public void setIdentityInfoDao(IdentityInfoDao identityInfoDao) {
        this.identityInfoDao = identityInfoDao;
    }

    @WebMethod(exclude = true)
    public void setIdentityQueryLogDao(IdentityQueryLogDao identityQueryLogDao) {
        this.identityQueryLogDao = identityQueryLogDao;
    }

    @WebMethod(operationName = "getvalues")
    public String getvalues(String sessionId, String idCard) {
        IdentityInfo identityInfo = identityInfoDao.exist(idCard);
        if (identityInfo != null) {
            String str = "{\"sessionid\":\"" + sessionId + "\"," +
                    "\"code\":\"" + identityInfo.getCode() + "\"," +
                    "\"xq\":\"" + identityInfo.getXq() + "\"," +
                    "\"compare_time\":\"" + identityInfo.getCompare_time() + "\"," +
                    "\"status\":\"" + identityInfo.getStatus() + "\"}";
            return str;
        } else {
            PersonCheckProxy p = new PersonCheckProxy();
            CheckResult r = null;
            try {
                r = p.check(System.currentTimeMillis() + "", idCard, "", "");
                logger.info(r.getCode() + "|" + r.getSessionId() + "|" + "" + r.getXq());
                IdentityInfo info = new IdentityInfo();
                info.setCode(r.getCode());
                info.setXq(r.getXq());
                info.setCompare_time(new Date());
                info.setStatus(1);
                identityInfoDao.save(info);
                identityQueryLogDao.save(new IdentityQueryLog(r.getSessionId(), info.getIdCard(), r.getCode(), r.getXq(), new Date()));
                String str = "{\"sessionid\":\"" + sessionId + "\"," +
                        "\"code\":\"" + r.getCode() + "\"," +
                        "\"xq\":\"" + r.getXq() + "\"," +
                        "\"compare_time\":\"" + new Date() + "\"," +
                        "\"status\":\"1\"}";
                return str;

            } catch (RemoteException e) {
                logger.error("对比出错" + idCard);
                identityInfoDao.save(new IdentityInfo(idCard));
                String str = "{\"sessionid\":\"" + sessionId + "\"," +
                        "\"code\":\"000\"," +
                        "\"xq\":\"未找到记录\"," +
                        "\"compare_time\":\"\"," +
                        "\"status\":\"0\"}";
                return str;
            }
        }
    }

   /* public static void main(String[] args) {
        Endpoint.publish("http://0.0.0.0:9019/Service/FindService", new FindService());
        System.out.println("Service Success!");
    }*/
}
