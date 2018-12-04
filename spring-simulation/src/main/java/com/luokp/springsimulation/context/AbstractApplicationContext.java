package com.luokp.springsimulation.context;

import com.luokp.springsimulation.beanDifinition.BeanDefinition;
import com.luokp.springsimulation.beanFactory.AbstractBeanFactory;
import com.luokp.springsimulation.beanFactory.BeanFactory;
import com.luokp.springsimulation.io.ResourceLoader;
import com.luokp.springsimulation.xmlReader.BeanDefinitionReader;

/**
 * @author: luokp
 * @date: 2018/12/3 17:40
 * @description:
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    protected AbstractApplicationContext( AbstractBeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }

    protected abstract void refresh() throws IllegalAccessException, InstantiationException, ClassNotFoundException, Exception;

}
