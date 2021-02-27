package com.framework.demo1.service;

import com.framework.demo1.entity.DeductReceiptRequest;
import com.framework.demo1.result.PayResult;
import com.framework.demo1.result.vo.DeductReceiptResultVo;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:09
 * @Description: 单笔代扣交易
 */
public interface DeductReceiptService {

    /**
     *  单笔代扣交易处理
     * @param deductReceiptRequest
     * @return
     */
    PayResult<DeductReceiptResultVo> onlineReceipt(final DeductReceiptRequest deductReceiptRequest);

}
