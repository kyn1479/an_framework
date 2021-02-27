package com.framework.demo1.command;

import com.framework.demo1.aggregate.DeductReceiptDomain;
import com.framework.demo1.template.PayCommand;
import org.springframework.stereotype.Component;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 21:25
 * @Description: 调用其他应用系统
 */
@Component
public class DeductReceiptSendCommand implements PayCommand<DeductReceiptDomain> {
    /**
     * 调用其他应用系统
     * @param deductReceiptDomain
     * @return
     */
    @Override
    public boolean execute(DeductReceiptDomain deductReceiptDomain) {

        return false;
    }
}
