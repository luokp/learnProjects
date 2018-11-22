package com.luokp;

import com.luokp.springsimulation.BeanDefinition;
import com.luokp.springsimulation.BeanFactory;

public class BeanFactoryTest {
    public static void main(String[] args) {
        BeanDefinition beanDefinition = new BeanDefinition(new HelloService());
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("helloService", beanDefinition);
        HelloService hello = (HelloService) beanFactory.getBean("helloService");
        hello.hello();
    }

}
