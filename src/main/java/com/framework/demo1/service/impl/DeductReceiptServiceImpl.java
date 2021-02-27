package com.framework.demo1.service.impl;

import com.framework.demo1.aggregate.AggregateBase;
import com.framework.demo1.aggregate.DeductReceiptDomain;
import com.framework.demo1.commandchain.DeductReceiptCommandChain;
import com.framework.demo1.entity.DeductReceiptRequest;
import com.framework.demo1.exception.PayException;
import com.framework.demo1.factory.DeductReceiptDomainFactory;
import com.framework.demo1.model.DeductReceiptOrder;
import com.framework.demo1.result.PayResult;
import com.framework.demo1.result.vo.DeductReceiptResultVo;
import com.framework.demo1.service.DeductReceiptService;
import com.framework.demo1.service.ServiceBase;
import com.framework.demo1.template.ServiceCallback;
import com.framework.demo1.template.ServiceTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:12
 * @Description: 单笔代扣业务逻辑实现
 */
@Service("deductReceiptService")
public class DeductReceiptServiceImpl extends ServiceBase implements DeductReceiptService {

    @Autowired
    protected ServiceTemplate serviceTemplate;
    /**
     * 单笔代扣领域模型生成工厂
     **/
    @Autowired
    private DeductReceiptDomainFactory deductReceiptDomainFactory;

    /**
     * 单笔代扣业务处理命令链
     **/
    @Autowired
    private DeductReceiptCommandChain deductReceiptCommandChain;

    @Override
    public PayResult<DeductReceiptResultVo> onlineReceipt(final DeductReceiptRequest deductReceiptRequest) {

        return serviceTemplate.execute(new ServiceCallback<AggregateBase, PayResult>() {
            @Override
            public AggregateBase beforeProcess() throws PayException {
                //判空
//                AssertUtils.isNotNull(deductReceiptRequest, SystemErrorCode.BIZ_PARAM_NULL);
                //参数校验
                deductReceiptRequest.check();
                //创建领域模型
                return deductReceiptDomainFactory.createDomain(deductReceiptRequest);
            }

            @Override
            public void execute(AggregateBase domain) throws PayException {
                deductReceiptCommandChain.execute(domain);
            }

            @Override
            public PayResult resultProcess(AggregateBase domain) {
                DeductReceiptDomain deductReceiptDomain = (DeductReceiptDomain) domain;
                DeductReceiptOrder deductReceiptOrder = deductReceiptDomain.getDeductReceiptOrder();
                //返回结果处理
                return new PayResult<DeductReceiptResultVo>(new DeductReceiptResultVo(
                        deductReceiptOrder.getPayOrderNo(),
                        deductReceiptOrder.getOutBizNo(),
                        deductReceiptOrder.getBizStatus(),
                        deductReceiptOrder.getRespCode(),
                        deductReceiptOrder.getRespMsg(),
                        deductReceiptOrder.getSuccessAmt()));
            }

        });
    }
}
