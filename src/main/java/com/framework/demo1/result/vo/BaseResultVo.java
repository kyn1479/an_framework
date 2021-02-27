package com.framework.demo1.result.vo;

import java.io.Serializable;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 0:12
 * @Description: 通用返回体基类
 */
public class BaseResultVo implements Serializable {

    private static final long serialVersionUID = -1L;

    /** 业务状态:
     *SUCCESS(成功),
     *DOING(处理中),
     *FAILED(失败),
     */
    private String bizStatus;

    /** 响应码*/
    private String respCode;

    /** 响应信息*/
    private String respMsg;
}
