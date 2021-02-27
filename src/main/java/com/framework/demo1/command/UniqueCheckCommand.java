package com.framework.demo1.command;

import com.framework.demo1.aggregate.AggregateBase;
import com.framework.demo1.aggregate.Domain;
import com.framework.demo1.template.PayCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 21:04
 * @Description: 幂等校验
 */
@Component
public class UniqueCheckCommand implements PayCommand<AggregateBase> {

    private final Logger logger = LoggerFactory.getLogger(UniqueCheckCommand.class);

    @Override
    public boolean execute(AggregateBase aggregateBase) {
        logger.info("进入幂等校验逻辑");
//        校验不通过则抛异常退出！
//            throw new PayException(SystemErrorCode.UNIQUE_CHECK_ERROR, uniqueKey);
        return true;
    }
}
