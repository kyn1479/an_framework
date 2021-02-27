package com.framework.demo1.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:11
 * @Description:
 */
public class ServiceBase implements ApplicationContextAware {

    /**
     * spring上下文，获取需要的bean
     */
    protected ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
