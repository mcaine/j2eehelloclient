package com.mikeycaine.helloclient.service;

import java.io.StringWriter;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceRef;

import com.mikeycaine.helloclient.generated.HelloWorld;
import com.mikeycaine.helloclient.generated.HelloWorldService;
import com.mikeycaine.helloclient.generated.ObjectFactory;


/**
 * Session Bean implementation class SessionBeanHello
 */
@Stateless
@LocalBean
public class SessionBeanHello {
	
    //@Inject
    //private Logger log;
    
	@WebServiceRef(wsdlLocation = "http://mike-virtualbox:8080/helloworld/HelloWorld?wsdl")
	private HelloWorldService service;
	 
    public SessionBeanHello() {
        // TODO Auto-generated constructor stub
    }
    
    public String greet (String person) {
    	HelloWorld port = (HelloWorld) service.getHelloWorldPort();	
    	return port.hello(person);
    }
}
