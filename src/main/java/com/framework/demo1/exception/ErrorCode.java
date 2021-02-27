package com.framework.demo1.exception;

import com.framework.demo1.enums.ExceptionTypeEnum;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/2 23:23
 * @Description: 异常信息接口
 */
public interface ErrorCode {
    /**
     * @Description 获取异常类型
     *
     * @Params
     * @Return
     * @Exceptions
     */
    ExceptionTypeEnum getExceptionType();

    /**
     * @Description 获取错误编码
     *
     * @Params
     * @Return
     * @Exceptions
     */
    String getCode();

    /**
     * @Description 获取错误消息（获取到的是key，可能需要进行资源文件转换成真正的错误消息）
     *
     * @Params
     * @Return
     * @Exceptions
     */
    String getMessage();
}
