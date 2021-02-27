package com.framework.demo1.entity;

import com.framework.demo1.enums.SystemErrorCode;
import com.framework.demo1.exception.PayException;
import com.framework.demo1.utils.StringUtils;
import com.framework.demo1.utils.ValidatorUtil;
import com.alibaba.fastjson.JSON;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:04
 * @Description: 抽象请求基类
 */
public abstract class AbstractRequest {

    /**
     * 调用方系统
     */
    @NotEmpty(message = "调用方系统编号不能为空")
    @Size(max = 20, message = "调用方系统编号最大长度为20")
    private String systemId;

    /**
     * 业务系统流水号, 外系统流水号
     */
    @NotEmpty(message = "外系统流水号不能为空")
    @Size(max = 128, message = "外系统流水号最大长度为128")
    private String outBizNo;


    /**
     * 入参检查
     */
    public void check() {
        String validMap = ValidatorUtil.validate(this);
        if (validMap != null && StringUtils.isNotEmpty(validMap)) {
            throw new PayException(SystemErrorCode.BIZ_CHECK_ERROR, JSON.toJSONString(validMap));
        }
    }

    public String getSystemId() {
        return systemId;
    }


    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }
}
