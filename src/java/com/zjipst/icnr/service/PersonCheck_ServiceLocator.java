/**
 * PersonCheck_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zjipst.icnr.service;

public class PersonCheck_ServiceLocator extends org.apache.axis.client.Service implements PersonCheck_Service {

    public PersonCheck_ServiceLocator() {
    }


    public PersonCheck_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PersonCheck_ServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PersonCheckImplPort
    private String PersonCheckImplPort_address = "http://172.18.18.40:8080/icnr-network/services/PersonCheck";

    public String getPersonCheckImplPortAddress() {
        return PersonCheckImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String PersonCheckImplPortWSDDServiceName = "PersonCheckImplPort";

    public String getPersonCheckImplPortWSDDServiceName() {
        return PersonCheckImplPortWSDDServiceName;
    }

    public void setPersonCheckImplPortWSDDServiceName(String name) {
        PersonCheckImplPortWSDDServiceName = name;
    }

    public PersonCheck_PortType getPersonCheckImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PersonCheckImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPersonCheckImplPort(endpoint);
    }

    public PersonCheck_PortType getPersonCheckImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.zjipst.icnr.service.PersonCheckSoapBindingStub _stub = new com.zjipst.icnr.service.PersonCheckSoapBindingStub(portAddress, this);
            _stub.setPortName(getPersonCheckImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPersonCheckImplPortEndpointAddress(String address) {
        PersonCheckImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (PersonCheck_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.zjipst.icnr.service.PersonCheckSoapBindingStub _stub = new com.zjipst.icnr.service.PersonCheckSoapBindingStub(new java.net.URL(PersonCheckImplPort_address), this);
                _stub.setPortName(getPersonCheckImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("PersonCheckImplPort".equals(inputPortName)) {
            return getPersonCheckImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.icnr.zjipst.com/", "PersonCheck");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.icnr.zjipst.com/", "PersonCheckImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("PersonCheckImplPort".equals(portName)) {
            setPersonCheckImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
