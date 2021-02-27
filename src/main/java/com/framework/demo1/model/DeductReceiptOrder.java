package com.framework.demo1.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:38
 * @Description: 代扣Order订单表对应实体类
 */
@Entity
@Table(name = "deduct_receipt_order")
public class DeductReceiptOrder extends BaseEntity {
    /** 业务系统流水号, 外系统流水号 */
    private String outBizNo ;

    /** 调用方系统 */
    private String systemId ;
    /** 付款账号 */
    private String acctNo ;

    /** 付款账户名 */
    private String acctName ;

    /** 证件类型 */
    private String certType ;

    /** 证件号码 */
    private String certNo ;

    /** 银行预留手机号 */
    private String bankPhoneNo ;

    /** 支付订单号 */
    private String payOrderNo ;

    /** 业务状态 */
    private String bizStatus ;

    /** 响应码 */
    private String respCode ;

    /** 响应信息 */
    private String respMsg ;

    /** 交易金额 */
    private BigDecimal transAmount ;

    /** 成功金额 */
    private BigDecimal successAmt ;

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
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

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getBankPhoneNo() {
        return bankPhoneNo;
    }

    public void setBankPhoneNo(String bankPhoneNo) {
        this.bankPhoneNo = bankPhoneNo;
    }

    public String getPayOrderNo() {
        return payOrderNo;
    }

    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    public String getBizStatus() {
        return bizStatus;
    }

    public void setBizStatus(String bizStatus) {
        this.bizStatus = bizStatus;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public BigDecimal getSuccessAmt() {
        return successAmt;
    }

    public void setSuccessAmt(BigDecimal successAmt) {
        this.successAmt = successAmt;
    }
}
