package com.framework.demo1.template;

import com.framework.demo1.exception.PayException;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/3 0:13
 * @Description: 通用服务模板回调接口
 */
public interface ServiceCallback<Domain, Result>{

    /**
     * @Description 前置加载模型
     * @Params
     * @Return
     * @Exceptions
     */
    Domain beforeProcess() throws PayException;

    /**
     * @Description 业务处理
     * @Params
     * @Return
     * @Exceptions
     */
    void execute(Domain domain) throws PayException;

    /**
     * @Description 结果处理
     * @Params
     * @Return
     * @Exceptions
     */
    Result resultProcess(Domain domain);
}
