package com.luokp.springsimulation.context;

import com.luokp.springsimulation.beanFactory.AbstractBeanFactory;
import com.luokp.springsimulation.beanFactory.AutowireCapableBeanFactory;
import com.luokp.springsimulation.beanFactory.BeanFactory;
import com.luokp.springsimulation.io.ResourceLoader;
import com.luokp.springsimulation.xmlReader.AbstractBeanDefinitionReader;
import com.luokp.springsimulation.xmlReader.BeanDefinitionReader;
import com.luokp.springsimulation.xmlReader.XmlBeanDefinitionReader;

/**
 * @author: luokp
 * @date: 2018/12/3 17:44
 * @description:
 */
public class ClassPathXmlApplicationContextXml extends AbstractApplicationContext {

    private String  configLocation;

    public ClassPathXmlApplicationContextXml(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    public ClassPathXmlApplicationContextXml(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    @Override
    protected void refresh() throws Exception {
        AbstractBeanDefinitionReader abstractBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        abstractBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for(String key : abstractBeanDefinitionReader.getRegistry().keySet()){
            beanFactory.registerBean(key, abstractBeanDefinitionReader.getRegistry().get(key));
        }
    }

    @Override
    public Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }
}
