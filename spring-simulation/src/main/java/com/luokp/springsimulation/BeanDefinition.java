package com.luokp.springsimulation;

public class BeanDefinition {
    private String beanClassName;
    private Object bean;

    public BeanDefinition(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public void setBeanClassName(String beanClassName){
        this.beanClassName = beanClassName;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
