package com.luokp.springsimulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: luokp
 * @date: 2018/11/27 13:00
 * @description:
 */
public class PropertyValues {
    private Map<Object, Object> propertyMap = new HashMap<>();

    public void addPropertyValue(Object propertyName, Object propertyValue){
        propertyMap.put(propertyName, propertyValue);
    }

    public Object getPropertyValue(Object propertyName){
        return propertyMap.get(propertyName);
    }

}
