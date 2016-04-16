package com.hzih.compare.web.servlet;

import com.hzih.compare.dao.IdentityInfoDao;
import com.hzih.compare.dao.IdentityQueryLogDao;
import com.hzih.compare.domain.IdentityInfo;
import com.hzih.compare.domain.IdentityQueryLog;
import com.zjipst.icnr.service.CheckResult;
import com.zjipst.icnr.service.PersonCheckProxy;
import org.apache.log4j.Logger;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

public class IdentityInfoTask extends TimerTask {

    private Logger logger = Logger.getLogger(IdentityInfoTask.class);

    private IdentityInfoDao identityInfoDao;
    private IdentityQueryLogDao identityQueryLogDao;
//    private static int maxRecords = 2000;

    public IdentityInfoTask(IdentityInfoDao identityInfoDao,IdentityQueryLogDao identityQueryLogDao) {
        this.identityInfoDao = identityInfoDao;
        this.identityQueryLogDao = identityQueryLogDao;
    }


    @Override
    public void run() {
        logger.info("*********************开始对比数据********************************");
        PersonCheckProxy p = new PersonCheckProxy();


        /*int count = 30000; //总条数
        int pages = count / maxRecords;
        pages += (int)Math.ceil(count % maxRecords);
        for (int i = 0; i < pages; i += 1) {
            int start = i * maxRecords + 1;
            if(start>=count){
                return;
            }
            int end = (i + 1) * maxRecords;
            if (end > count) {
                end = count;
            }
        }*/


        List<IdentityInfo> list = identityInfoDao.list(0);
        for(IdentityInfo identityInfo : list) {
            CheckResult r = null;
            try {
                r = p.check(System.currentTimeMillis()+"",  identityInfo.getIdCard(), "", "");
                logger.info(r.getCode()+"|"+r.getSessionId()+"|"+""+r.getXq());
                identityInfo.setCode(r.getCode());
                identityInfo.setXq(r.getXq());
                identityInfo.setCompare_time(new Date());
                identityInfo.setStatus(1);
                identityInfoDao.update(identityInfo);
                identityQueryLogDao.save(new IdentityQueryLog(r.getSessionId(), identityInfo.getIdCard(), r.getCode(), r.getXq(),new Date()));
            } catch (RemoteException e) {
                logger.error("对比出错"+identityInfo.getIdCard(),e);
            }
        }
        logger.info("*********************结束对比数据********************************");
    }
}