package com.framework.demo1.commandchain;

import com.framework.demo1.aggregate.Domain;
import com.framework.demo1.template.PayCommand;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:57
 * @Description: 命令执行链
 */
public class CommandChain {
    /**
     * 需要执行的命令
     */
    private List<PayCommand> commands = new LinkedList<>();

    /**
     * @Description 增加命令
     *
     * @Params
     * @Return
     * @Exceptions
     */
    protected void addCommand(PayCommand payCommand){
        commands.add(payCommand);
    }

    /**
     * @Description 命令执行
     *
     * @Params
     * @Return
     * @Exceptions
     */
    public void execute(Domain domain){
        for (PayCommand command:commands){
            if(!command.execute(domain)){
                //如果执行失败，则中断
                return;
            }
        }
    }
}
