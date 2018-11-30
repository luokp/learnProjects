package com.luokp.springsimulation.beanDifinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: luokp
 * @date: 2018/11/30 19:36
 * @description: reference bean.
 */
public class BeanReference {
    private String beanClassType;
    private String beanName;

    public String getBeanClassType() {
        return beanClassType;
    }

    public void setBeanClassType(String beanClassType) {
        this.beanClassType = beanClassType;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
