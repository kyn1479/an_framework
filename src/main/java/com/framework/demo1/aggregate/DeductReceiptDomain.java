package com.framework.demo1.aggregate;

import com.framework.demo1.model.DeductReceiptDetail;
import com.framework.demo1.model.DeductReceiptOrder;

import java.util.List;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:35
 * @Description: 单笔代扣领域模型
 */
public class DeductReceiptDomain extends AggregateBase {
    /** 代扣订单 **/
    private DeductReceiptOrder deductReceiptOrder;

    /** 代扣明细 **/
    private List<DeductReceiptDetail> deductReceiptDetails;

    public DeductReceiptOrder getDeductReceiptOrder() {
        return deductReceiptOrder;
    }

    public void setDeductReceiptOrder(DeductReceiptOrder deductReceiptOrder) {
        this.deductReceiptOrder = deductReceiptOrder;
    }

    public List<DeductReceiptDetail> getDeductReceiptDetails() {
        return deductReceiptDetails;
    }

    public void setDeductReceiptDetails(List<DeductReceiptDetail> deductReceiptDetails) {
        this.deductReceiptDetails = deductReceiptDetails;
    }

    public DeductReceiptDomain() {
        this.deductReceiptOrder = new DeductReceiptOrder();
    }

    public DeductReceiptDomain(DeductReceiptOrder deductReceiptOrder) {
        this.deductReceiptOrder = deductReceiptOrder;
    }

    public DeductReceiptDomain(DeductReceiptOrder deductReceiptOrder, List<DeductReceiptDetail> deductReceiptDetails) {
        this.deductReceiptOrder = deductReceiptOrder;
        this.deductReceiptDetails = deductReceiptDetails;
    }

    @Override
    public void selfCheck() {

    }

    @Override
    public String getUniqueKey() {
        return null;
    }

    @Override
    public String getBizOrderNo() {
        return null;
    }

    @Override
    public boolean isNeedNotify() {
        return false;
    }
}
