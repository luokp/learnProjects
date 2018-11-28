package com.luokp.springsimulation.beanFactory;

import com.luokp.springsimulation.beanDifinition.BeanDefinition;

public interface BeanFactory {

    void registerBean(String name, BeanDefinition beanDefinition) throws ClassNotFoundException, IllegalAccessException, InstantiationException;

    Object getBean(String name);
}
