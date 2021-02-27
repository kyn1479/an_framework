package com.framework.demo1.template;

import com.framework.demo1.aggregate.Domain;
import com.framework.demo1.enums.SystemErrorCode;
import com.framework.demo1.result.PayResult;
import com.framework.demo1.exception.PayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/2 23:13
 * @Description: 通用服务模板
 */
@Service("serviceTemplate")
public class ServiceTemplate {
    private static final Logger logger = LoggerFactory.getLogger(ServiceTemplate.class);

//    @Autowired
//    private ActivePayService activePayService;
//
//    @Autowired
//    private UniqueCheckRemoveCommand uniqueCheckRemoveCommand;


    /**
     * 调用接口服务-1
     * @param callback
     * @param <R>
     * @return
     */
    public <R> PayResult<R> execute(Callable<R> callback) {
        PayResult<R> result;
        try {
            logger.debug("进入通用服务模板");

            //具体业务处理
            R bizResult = callback.call();

            result = new PayResult<>(bizResult);
            result.setErrcode("0");
            result.setErrmsg("操作成功");

            logger.debug("退出通用服务模板");

            return result;

        } catch (PayException e) {
            logger.error("通用服务异常", e);
            return new PayResult<>(e.getErrorCode(), e.getErrorMsg());
        } catch (DataAccessException e) {
            logger.error("通用服务访问数据库异常：{}", e);
            return new PayResult<>(SystemErrorCode.DATA_ACCESS_ERROR);
        } catch (Exception e) {
            logger.error("通用服务系统异常", e);
            return new PayResult<>(SystemErrorCode.SYSTEM_ERROR, e.getMessage());
        }
    }

    /**
     * 调用接口服务-2
     * @param action
     * @param <P>
     * @return
     */
    public <P extends Domain> PayResult execute(ServiceCallback<P ,PayResult> action ){
        P domain = null;
        PayResult result;
        try {
            logger.debug("进入通用服务模板");

            //前置处理，生成或者加载领域对象
            domain = action.beforeProcess();

            //具体业务处理
            action.execute(domain);

            //执行返回
            result = action.resultProcess(domain);

        } catch (PayException e) {
            logger.error("通用服务异常:", e);
            return new PayResult(e.getErrorCode(), e.getErrorMsg());
        } catch (DataAccessException e) {
            logger.error("通用服务访问数据库异常", e);
            return new PayResult(SystemErrorCode.DATA_ACCESS_ERROR);
        } catch (Exception e) {
            logger.error("通用服务系统异常", e);
            return new PayResult(SystemErrorCode.SYSTEM_ERROR);
        } finally {
//            if (domain != null && domain instanceof AggregateBase && ((AggregateBase) domain).isNeedNotify()) {
//                activePayService.notifyBiz((AggregateBase) domain);
//            }
//            if (domain != null && domain instanceof AggregateBase && ((AggregateBase) domain).isRemoveUniqueK()) {
//                uniqueCheckRemoveCommand.execute((AggregateBase) domain);
//            }
        }
        logger.debug("退出通用服务模板");
        return result;
    }
}
