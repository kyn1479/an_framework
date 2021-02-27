package com.framework.demo1.model;

import java.io.Serializable;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:37
 * @Description:
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
