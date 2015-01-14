package com.mikeycaine.helloclient.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;

import org.slf4j.Logger;

import com.cdyne.ws.weatherws.ArrayOfWeatherDescription;
import com.cdyne.ws.weatherws.Weather;
import com.cdyne.ws.weatherws.WeatherDescription;
import com.cdyne.ws.weatherws.WeatherSoap;

@Stateless
@LocalBean
public class WeatherBean implements WeatherBeanLocal {
	
	//@Inject
	//private Logger log;	
	
	//@WebServiceRef(wsdlLocation="http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL")
	
	// Weather is the name of the Service class. Weather extends javax.xml.ws.Service
	// WeatherSoap is annotated with @WebService in the generated code
	@WebServiceRef(Weather.class)
	private WeatherSoap weatherSoap;
    /**
     * Default constructor. 
     */
    public WeatherBean() {
        // TODO Auto-generated constructor stub
    		
    }
    
    @Override
    public String getWxInfo() {
    	//log.info("About to get weather info...");
    	ArrayOfWeatherDescription arr = weatherSoap.getWeatherInformation();
    	StringBuilder sb = new StringBuilder();
    	List<WeatherDescription> descs = arr.getWeatherDescription();
    	for (WeatherDescription desc : descs) {
    		sb.append("[" + desc.getWeatherID() + "] " + desc.getDescription() + "\n");
    	}
    	return sb.toString();
    }
}



