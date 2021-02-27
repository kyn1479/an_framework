package com.framework.demo1.enums;

import com.framework.demo1.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/2 23:27
 * @Description:
 */
public enum SystemErrorCode implements ErrorCode {
    SUCCESS("G000", "交易成功"),
    PROCESS("G001", "交易处理中"),
    FAIL("G002", "交易失败"),
    ACCEPT("G003", "交易已受理"),
    SYSTEM_ERROR("G201", "系统内部异常"),
    ILLEGAL_PARAM("G252", "业务参数校验异常{0}"),
    VALIDATE_ERROR("G240", "参数错误格式错误"),
    OPTION_VALIDATE_ERROR("G241", "参数错误：{0}不能为空"),
    LENGTH_VALIDATE_ERROR("G242", "参数错误：{0}长度不正确"),
    REGEX_VALIDATE_ERROR("G243", "参数错误：{0}格式不正确"),
    TYPE_VALIDATE_ERROR("G244", "参数错误：{0}格式不正确"),
    TRANS_CODE_UNDEFINED("G245", "交易码({0})未定义"),
    TRANS_TYPE_UNDEFINED("G246", "交易类型({0})未定义"),
    TRANSFORM_TYPE_UNDEFINED("G209", "报文类型({0})未定义"),
    TRANS_NOT_EXIST("G236", "交易流水({0})不存在"),
    UNSUPPORT("G251", "不支持的{0}"),
    TRANSFORM_ENCODE_UNDEFINED("G210", "报文编码({0})未定义"),
    DATA_NOT_EXIST("G237", "数据{0}不存在"),
    HAS_EXIST("G232", "数据{0}已存在"),
    DATA_ACCESS_ERROR("G202","数据访问异常[{0}]"),
    BIZ_CHECK_ERROR("G203","参数校验异常[{0}]"),
    ;


    /**
     * 枚举值
     */
    private final String code;

    /**
     * 枚举描述
     */
    private final String message;



    /**
     * 构造一个<code>SystemErrorCode</code>枚举对象
     *
     * @param code
     * @param message
     */
    private SystemErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return Returns the code.
     */
    public String code() {


        return code;
    }

    /**
     * @return Returns the message.
     */
    public String message() {
        return message;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code
     * @return SystemErrorCode
     */
    public static SystemErrorCode getByCode(String code) {
        for (SystemErrorCode _enum : values()) {
            if (_enum.getCode().equals(code)) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<SystemErrorCode>
     */
    public static List<SystemErrorCode> getAllEnum() {
        List<SystemErrorCode> list = new ArrayList<SystemErrorCode>();
        for (SystemErrorCode _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public  static List<String> getAllEnumCode() {
        List<String> list = new ArrayList<String>();
        for (SystemErrorCode _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * @Description 获取异常类型
     * @Params
     * @Return
     * @Exceptions
     */
    @Override
    public ExceptionTypeEnum getExceptionType() {
        return ExceptionTypeEnum.SYSTEM_ERROR;
    }

    /**
     * @Description 获取错误编码
     * @Params
     * @Return
     * @Exceptions
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * @Description 获取错误消息（获取到的是key，可能需要进行资源文件转换成真正的错误消息）
     * @Params
     * @Return
     * @Exceptions
     */
    @Override
    public String getMessage() {
        return this.message;
    }

    public static void main(String[] args) {

    }
}
