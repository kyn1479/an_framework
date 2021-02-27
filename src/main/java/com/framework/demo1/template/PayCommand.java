package com.framework.demo1.template;


/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:59
 * @Description:
 */
public interface PayCommand<Domain> {

    /**
     * 命令执行
     * @param domain
     * @return
     */
    boolean execute(Domain domain);
}
