package com.luokp;

import com.luokp.springsimulation.BeanDefinition;
import com.luokp.springsimulation.beanFactory.AutowireCapableBeanFactory;
import com.luokp.springsimulation.beanFactory.BeanFactory;

public class BeanFactoryTest {
    public static void main(String[] args) {
        BeanDefinition beanDefinition = new BeanDefinition("com.luokp.HelloService");
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
        HelloService hello = (HelloService) beanFactory.getBean("helloService");
        hello.hello();
    }

}
