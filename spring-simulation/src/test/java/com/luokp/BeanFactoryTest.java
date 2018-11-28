package com.luokp;

import com.luokp.springsimulation.BeanDefinition;
import com.luokp.springsimulation.PropertyValues;
import com.luokp.springsimulation.beanFactory.AutowireCapableBeanFactory;
import com.luokp.springsimulation.beanFactory.BeanFactory;

import java.util.HashMap;
import java.util.Map;

public class BeanFactoryTest {
    public static void main(String[] args) {

        //bean元数据
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue("name","luokp");
        propertyValues.addPropertyValue("gender", "male");
        propertyValues.addPropertyValue("age", 30);
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.luokp.HelloService");
        beanDefinition.setPropertyValues(propertyValues);

        //注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        try {
            beanFactory.registerBean("helloService", beanDefinition);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        //从容器中获取bean
        HelloService hello = (HelloService) beanFactory.getBean("helloService");
        hello.hello();
    }

}
