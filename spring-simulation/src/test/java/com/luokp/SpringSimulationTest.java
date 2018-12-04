package com.luokp;

import com.luokp.springsimulation.beanFactory.AutowireCapableBeanFactory;
import com.luokp.springsimulation.beanFactory.BeanFactory;
import com.luokp.springsimulation.context.ApplicationContext;
import com.luokp.springsimulation.context.ClassPathXmlApplicationContextXml;
import com.luokp.springsimulation.io.ResourceLoader;
import com.luokp.springsimulation.xmlReader.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.ArrayDeque;

public class SpringSimulationTest {

    @Test
    public  void test() throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContextXml("spring-simulation.xml");

        //从容器中获取bean
        HelloService hello1 = (HelloService) applicationContext.getBean("hello1");
        hello1.hello();

        System.out.println("\n---------------------------------\n");

        HelloService hello2 = (HelloService) applicationContext.getBean("hello2");
        hello2.hello();
        System.out.println("\n---------------------------------\n");

        ArrayDeque<Integer> stack = new ArrayDeque<>();
    }

}
