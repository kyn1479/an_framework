package com.framework.demo1.repository.impl;

import com.framework.demo1.aggregate.DeductReceiptDomain;
import com.framework.demo1.model.DeductReceiptOrder;
import com.framework.demo1.repository.DeductReceiptDomainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 21:17
 * @Description: 单笔代扣领域仓储实现类
 */
@Component
public class DeductReceiptDomainRepositoryImpl implements DeductReceiptDomainRepository {
    private static final Logger logger = LoggerFactory.getLogger(DeductReceiptDomainRepositoryImpl.class);

    @Override
    public void store(DeductReceiptDomain deductReceiptDomain) {
        // 保存代扣订单
        DeductReceiptOrder deductReceiptOrder = deductReceiptDomain.getDeductReceiptOrder();

    }
}
