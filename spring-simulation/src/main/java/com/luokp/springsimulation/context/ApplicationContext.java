package com.luokp.springsimulation.context;

import com.luokp.springsimulation.beanFactory.BeanFactory;

public interface ApplicationContext  {
    Object getBean(String beanName);
}
