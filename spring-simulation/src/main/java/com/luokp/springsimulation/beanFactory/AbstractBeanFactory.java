package com.luokp.springsimulation.beanFactory;

import com.luokp.springsimulation.beanDifinition.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanFactory implements BeanFactory{

    private Map<String, BeanDefinition> container = new HashMap<>();

    public void registerBean(String name, BeanDefinition beanDefinition) throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        Object bean = createBean(beanDefinition);
        beanDefinition.setBean(bean);
        container.put(name, beanDefinition);

    }

    public Object getBean(String name){
        return container.get(name).getBean();
    }

    public abstract  Object createBean(BeanDefinition beanDefinition);
}
