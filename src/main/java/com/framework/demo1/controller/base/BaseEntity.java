package com.framework.demo1.controller.base;

import java.io.Serializable;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/2 23:42
 * @Description: 实体类基类
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    protected Long id;

    /**
     * 数据版本，用于乐观锁
     */
    private Long version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
