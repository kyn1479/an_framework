package com.framework.demo1.factory;

import com.framework.demo1.aggregate.DeductReceiptDomain;
import com.framework.demo1.entity.DeductReceiptRequest;
import com.framework.demo1.model.DeductReceiptOrder;
import org.springframework.stereotype.Component;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:33
 * @Description: 单笔代扣领域生成工厂
 */
@Component
public class DeductReceiptDomainFactory {

    /**
     * 创建领域对象
     * @Description 创建单笔代扣领域对象
     * @Params request 前端请求参数
     * @Return 领域模型对象
     * @Exceptions
     */
    public DeductReceiptDomain createDomain(DeductReceiptRequest request) {
        DeductReceiptOrder deductReceiptOrder = new DeductReceiptOrder();
        deductReceiptOrder.setSystemId(request.getSystemId());
        deductReceiptOrder.setOutBizNo(request.getOutBizNo());
        deductReceiptOrder.setAcctName(request.getAcctName());
        deductReceiptOrder.setAcctNo(request.getAcctNo());
        deductReceiptOrder.setBankPhoneNo(request.getBankPhoneNo());
        deductReceiptOrder.setTransAmount(request.getTransAmt());
        return new DeductReceiptDomain(deductReceiptOrder);
    }
}
