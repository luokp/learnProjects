package com.luokp.springsimulation.xmlReader;

import com.luokp.springsimulation.beanDifinition.BeanDefinition;
import com.luokp.springsimulation.io.ResourceLoader;
import java.util.HashMap;
import java.util.Map;

/**
 * 从配置中读取BeanDefinitionReader
 * 
 * @author yihua.huang@dianping.com
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
