package com.framework.demo1.repository;

import com.framework.demo1.aggregate.DeductReceiptDomain;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 21:16
 * @Description: 单笔代扣领域仓储
 */
public interface DeductReceiptDomainRepository extends AggregateDomainRepository  {
    /**
     * 存储领域对象
     * @Description 存储领域对象
     * @Params deductReceiptDomain 领域对象
     * @Return
     * @Exceptions
     */
    void store(DeductReceiptDomain deductReceiptDomain);
}
