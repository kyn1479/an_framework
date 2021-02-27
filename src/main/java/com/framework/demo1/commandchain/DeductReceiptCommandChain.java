package com.framework.demo1.commandchain;

import com.framework.demo1.command.DeductReceiptSaveCommand;
import com.framework.demo1.command.DeductReceiptSendCommand;
import com.framework.demo1.command.UniqueCheckCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 21:01
 * @Description: 代扣执行链
 */
@Component
public class DeductReceiptCommandChain extends CommandChain {
    /**
     * 构造函数将具体命令加入命令顺序列表
     */
    @Autowired
    public DeductReceiptCommandChain(UniqueCheckCommand uniqueCheckCommand,
                                     DeductReceiptSaveCommand deductReceiptSaveCommand,
                                     DeductReceiptSendCommand deductReceiptSendCommand
                                     ){

        // 1.添加幂等性校验指令
        addCommand(uniqueCheckCommand);

        //2.添加保存数据库指令
        addCommand(deductReceiptSaveCommand);

        //3.添加单笔代付发送指令
        addCommand(deductReceiptSendCommand);


    }
}
