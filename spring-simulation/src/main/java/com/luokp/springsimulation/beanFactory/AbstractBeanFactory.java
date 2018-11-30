package com.luokp.springsimulation.beanFactory;

import com.luokp.springsimulation.beanDifinition.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory{

    private static final Map<String, BeanDefinition> container = new ConcurrentHashMap<>();


    public void registerBean(String beabName, BeanDefinition beanDefinition) throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        container.put(beabName, beanDefinition);
    }

    protected boolean hasBean(String beanName){
        return container.get(beanName).getBean() != null;
    }

    public Object getBean(String beanName){
        BeanDefinition beanDefinition = container.get(beanName);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No beanDefinition named " + beanName + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if(bean == null){
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void preInstantiateSingletons(){
        for(String beanName : container.keySet()){
            getBean(beanName);
        }
    }

    public abstract  Object doCreateBean(BeanDefinition beanDefinition);
}
