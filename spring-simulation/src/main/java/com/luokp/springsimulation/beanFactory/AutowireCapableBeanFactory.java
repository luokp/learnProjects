package com.luokp.springsimulation.beanFactory;

import com.luokp.springsimulation.beanDifinition.BeanDefinition;
import com.luokp.springsimulation.beanDifinition.BeanReference;
import com.luokp.springsimulation.beanDifinition.PropertyValues;

import java.lang.reflect.Field;
import java.util.Set;

public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    public Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Class clazz = Class.forName(beanDefinition.getBeanClassName());
            Object bean = clazz.newInstance();

            //注入属性
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            Set<Object> keySet = propertyValues.getPropertyMap().keySet();
            for( Object key : keySet){
                String propertyName = (String)key;
                Field field = clazz.getDeclaredField(propertyName);
                field.setAccessible(true);
                Object propertyValue = propertyValues.getPropertyMap().get(propertyName);
                if( propertyValue instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) propertyValue;
                    propertyValue = getBean(beanReference.getBeanName());
                }
                field.set(bean, propertyValue);
            }
            beanDefinition.setBean(bean);
            return bean;
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }


}
