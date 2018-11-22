package com.luokp.springsimulation;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private Map<String, BeanDefinition> container = new HashMap<>();

    public void registerBean(String name, BeanDefinition beanDefinition){
        container.put(name, beanDefinition);
    }

    public Object getBean(String name){
        return container.get(name).getBean();
    }
}
