package com.mikeycaine.helloclient.service;

import javax.ejb.Local;

@Local
public interface WeatherBeanLocal {
    String getWxInfo();
}
