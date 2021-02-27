package com.framework.demo1.controller;


import com.framework.demo1.template.ServiceTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/2 23:12
 * @Description: 接口控制器基类
 */
public class BaseApiController {

    /** logger*/
    public final static Logger logger = LoggerFactory.getLogger(BaseApiController.class);

    /** 服务模板*/
    @Autowired
    protected ServiceTemplate serviceTemplate;
}
