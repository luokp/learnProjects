package com.luokp.springsimulation.beanFactory;

import com.luokp.springsimulation.BeanDefinition;

public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    public Object createBean(BeanDefinition beanDefinition) {
        try {
            Class clazz = Class.forName(beanDefinition.getBeanClassName());
            Object bean = clazz.newInstance();
            return bean;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }


}
