package com.framework.demo1.result;

import com.framework.demo1.exception.ErrorCode;

import java.io.Serializable;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/2 23:18
 * @Description: 通用返回值基类
 */
public class PayResult <T> implements Serializable {


    /**  受理成功标志
     * 注：受理成功时才会返回结果data（bizStatus业务状态）*/
    private boolean success;

    /** 错误码，成功时为空*/
    private String errcode;

    /** 错误信息，成功时为空*/
    private String errmsg;

    /**  结果数据*/
    private T data;

    public PayResult(){
        this.success =true;
    }

    public PayResult(T data){
        this.success=true;
        this.data=data;
    }

    public PayResult(ErrorCode error) {
        this.success = false;
        if(error!=null){
            this.errcode = error.getCode();
            this.errmsg = error.getMessage();
        }
    }

    public PayResult(ErrorCode error, String msg) {
        this.success = false;
        if(error!=null){
            this.errcode = error.getCode();
//            this.errmsg = String.format("{}:{}",error.getMessage(),msg);
            this.errmsg = msg;
        }
    }

    public PayResult(String errCode, String errMsg) {
        this.success = false;
        this.errcode = errCode;
        this.errmsg = errMsg;
    }
    public void initResult(boolean success,String errCode,String errMsg,T data){
        this.success = success;
        this.errcode = errCode;
        this.errmsg = errMsg;
        this.data = data;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
