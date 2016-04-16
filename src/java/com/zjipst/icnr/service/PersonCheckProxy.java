package com.zjipst.icnr.service;

public class PersonCheckProxy implements com.zjipst.icnr.service.PersonCheck_PortType {
  private String _endpoint = null;
  private com.zjipst.icnr.service.PersonCheck_PortType personCheck_PortType = null;
  
  public PersonCheckProxy() {
    _initPersonCheckProxy();
  }
  
  public PersonCheckProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonCheckProxy();
  }
  
  private void _initPersonCheckProxy() {
    try {
      personCheck_PortType = (new com.zjipst.icnr.service.PersonCheck_ServiceLocator()).getPersonCheckImplPort();
      if (personCheck_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personCheck_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personCheck_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personCheck_PortType != null)
      ((javax.xml.rpc.Stub)personCheck_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.zjipst.icnr.service.PersonCheck_PortType getPersonCheck_PortType() {
    if (personCheck_PortType == null)
      _initPersonCheckProxy();
    return personCheck_PortType;
  }
  
  public CheckResult check(String sessionId, String cardId, String name, String password) throws java.rmi.RemoteException{
    if (personCheck_PortType == null)
      _initPersonCheckProxy();
    return personCheck_PortType.check(sessionId, cardId, name, password);
  }
  
  
}