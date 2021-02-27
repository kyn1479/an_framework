package com.framework.demo1.command;

import com.framework.demo1.aggregate.DeductReceiptDomain;
import com.framework.demo1.template.PayCommand;
import org.springframework.stereotype.Component;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 21:14
 * @Description:
 */
@Component
public class DeductReceiptSaveCommand implements PayCommand<DeductReceiptDomain> {

    @Override
    public boolean execute(DeductReceiptDomain deductReceiptDomain) {
        return false;
    }
}
