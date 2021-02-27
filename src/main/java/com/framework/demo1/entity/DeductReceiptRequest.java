package com.framework.demo1.entity;

import com.alibaba.fastjson.JSON;
import com.framework.demo1.enums.SystemErrorCode;
import com.framework.demo1.exception.PayException;
import com.framework.demo1.utils.StringUtils;
import com.framework.demo1.utils.ValidatorUtil;
import com.sun.prism.impl.ps.BaseShaderContext;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:03
 * @Description:
 */
public class DeductReceiptRequest extends AbstractRequest {
    /**
     * 付款账号
     */
    @NotEmpty(message = "付款账号不能为空")
    @Size(max = 32, message = "付款账号最大长度为32")
    private String acctNo;

    /**
     * 付款账户名
     */
    @Size(max = 128, message = "付款账户名最大长度为128")
    private String acctName;

    /**
     * 银行预留手机号
     */
    @Size(max = 11, message = "银行预留手机号长度为11")
    private String bankPhoneNo;

    /**
     * 总金额
     */
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "9999999999999.99")
    private BigDecimal transAmt;


    /**
     * 入参检查
     */
    @Override
    public void check() {
        String validMap = ValidatorUtil.validate(this);
        if (StringUtils.isNotEmpty(validMap)) {
            throw new PayException(SystemErrorCode.BIZ_CHECK_ERROR, JSON.toJSONString(validMap));
        }
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getBankPhoneNo() {
        return bankPhoneNo;
    }

    public void setBankPhoneNo(String bankPhoneNo) {
        this.bankPhoneNo = bankPhoneNo;
    }

    public BigDecimal getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(BigDecimal transAmt) {
        this.transAmt = transAmt;
    }
}
