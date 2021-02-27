package com.framework.demo1.result.vo;

import java.math.BigDecimal;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 0:15
 * @Description:
 */
public class DeductReceiptResultVo extends BaseResultVo {
    /** 业务系统流水号, 外系统流水号 */
    private String outBizNo ;
    /** 支付订单号 */
    private String payOrderNo ;

    /** 业务状态 */
    private String bizStatus ;

    /** 响应码 */
    private String respCode ;

    /** 响应信息 */
    private String respMsg ;

    /** 成功金额 */
    private BigDecimal successAmt ;

    public DeductReceiptResultVo(String outBizNo, String payOrderNo, String bizStatus, String respCode, String respMsg, BigDecimal successAmt) {
        this.outBizNo = outBizNo;
        this.payOrderNo = payOrderNo;
        this.bizStatus = bizStatus;
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.successAmt = successAmt;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
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

    public BigDecimal getSuccessAmt() {
        return successAmt;
    }

    public void setSuccessAmt(BigDecimal successAmt) {
        this.successAmt = successAmt;
    }
}
