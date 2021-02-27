package com.framework.demo1.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:43
 * @Description:
 */
@Entity
@Table(name = "deduct_receipt_detail")
public class DeductReceiptDetail extends BaseEntity {
    /** 支付订单号 */
    private String payOrderNo ;

    /** 付款账户名 */
    private String acctName ;

    /** 证件号码 */
    private String certNo ;

    /** 银行预留手机号 */
    private String bankPhoneNo ;

    /** 网关交易金额 */
    private BigDecimal transAmount ;

    /** 响应码 */
    private String respCode ;

    /** 响应信息 */
    private String respMsg ;

}
