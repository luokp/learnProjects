package com.luokp;

import com.luokp.springsimulation.beanFactory.AutowireCapableBeanFactory;
import com.luokp.springsimulation.beanFactory.BeanFactory;
import com.luokp.springsimulation.io.ResourceLoader;
import com.luokp.springsimulation.xmlReader.XmlBeanDefinitionReader;
import org.junit.Test;

public class SpringSimulationTest {

    @Test
    public  void test() throws Exception {

        //bean元数据
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("spring-simulation.xml");

        //注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(String key : xmlBeanDefinitionReader.getRegistry().keySet()){
            beanFactory.registerBean(key, xmlBeanDefinitionReader.getRegistry().get(key));
        }

        //从容器中获取bean
        HelloService hello1 = (HelloService) beanFactory.getBean("hello1");
        hello1.hello();

        System.out.println("\n---------------------------------\n");

        HelloService hello2 = (HelloService) beanFactory.getBean("hello2");
        hello2.hello();
        System.out.println("\n---------------------------------\n");
    }

}
