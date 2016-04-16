/**
 * PersonCheck_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zjipst.icnr.service;

public interface PersonCheck_PortType extends java.rmi.Remote {
    public CheckResult check(String sessionId, String cardId, String name, String password) throws java.rmi.RemoteException;
}
