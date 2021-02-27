package com.framework.demo1.aggregate;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/2 23:40
 * @Description: 聚合基类
 */
public abstract class AggregateBase implements Domain {

    /** 是否移除幂等性校验key */
    private boolean removeUnique = false;

    /** 是否外部生成渠道请求流水标识 */
    private boolean outInstReq = false;

    /**
     * @Description 聚合自我检查，一般指模型边界和业务规则的检查
     * @Params
     * @Return void
     * @Exceptions
     */
    public abstract void selfCheck();

    /**
     * @Description 获取唯一性判断标识
     * @Params
     * @Return
     * @Exceptions
     */
    public abstract String getUniqueKey();

    /**
     * 获取业务订单号
     * @return
     */
    public abstract String getBizOrderNo();

    /**
     * 是否需要异常幂等性校验缓存key
     * @return
     */
    public boolean isRemoveUniqueK(){
        return removeUnique;
    }

    /**
     * 是否需要异步MQ通知
     * @return
     */
    public abstract boolean isNeedNotify();

    public boolean isRemoveUnique() {
        return removeUnique;
    }

    public void setRemoveUnique(boolean removeUnique) {
        this.removeUnique = removeUnique;
    }

    public boolean isOutInstReq() {
        return outInstReq;
    }

    public void setOutInstReq(boolean outInstReq) {
        this.outInstReq = outInstReq;
    }
}
