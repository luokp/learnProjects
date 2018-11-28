package com.luokp.springsimulation;

public class BeanDefinition {
    private Object bean;
    private String beanClassName;
    private PropertyValues propertyValues;

    public BeanDefinition() {
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

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
