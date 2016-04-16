package com.zjipst.icnr.service;

import com.hzih.compare.myjfree.SysCpuInfo;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;

public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonCheckProxy  p = new PersonCheckProxy();
		try {
			CheckResult r = p.check(System.currentTimeMillis()+"", "320102198204022439", "", "");
			System.out.println("code:"+r.getCode());
			System.out.println("session:"+r.getSessionId());
			System.out.println("xq:"+r.getXq());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
