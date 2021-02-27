package com.framework.demo1.utils;

import com.framework.demo1.enums.SystemErrorCode;
import com.framework.demo1.exception.PayException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:17
 * @Description:
 */
public final class ValidatorUtil {
    private static Validator validator = null;

    static{
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private ValidatorUtil() {}


    /**
     * 判断属性是否属于例外属性列表
     * @return true--是例外属性,false--不是例外属性
     */
    private static boolean isExcept(String field, String... exceptFieldName){
        for(String obj : exceptFieldName){
            if(StringUtils.isNotBlank(obj) && field.indexOf(obj)>=0){
                return true;
            }
        }
        return false;
    }


    /**
     * 验证对象中的属性的值是否符合注解定义
     * @param obj 需要验证的对象
     * @return 返回空字符串""表示验证通过,否则返回错误信息,多个字段的错误信息用英文分号[;]分隔
     */
    public static String validate(Object obj){
        return validate(obj, new String[]{});
    }


    /**
     * 验证对象中的属性的值是否符合注解定义
     * @param obj             需要验证的对象
     * @param exceptFieldName 不需要验证的属性
     * @return 返回空字符串""表示验证通过,否则返回错误信息,多个字段的错误信息用英文分号[;]分隔
     */
    public static String validate(Object obj, String... exceptFieldName){
        String validateMsg = "";
        if(null == obj){
            return "被验证对象不能为null";
        }
        Set<ConstraintViolation<Object>> validateSet = validator.validate(obj);
        for(ConstraintViolation<Object> constraintViolation : validateSet){
            String field = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            if(!isExcept(field, exceptFieldName)){
                //id:最小不能小于1;name:不能为空;
                validateMsg += field + ":" + message + ";";
            }
        }
        return validateMsg;
    }


    /**
     * 验证对象中的属性的值是否符合注解定义
     * @param obj 需要验证的对象
     * @return 返回空Map<String, String>(not null)表示验证通过,否则会将各错误字段作为key放入Map,value为错误信息
     */
    public static Map<String, String> validateToMap(Object obj){
        return validateToMap(obj, new String[]{});
    }


    /**
     * 验证对象中的属性的值是否符合注解定义
     * @param obj             需要验证的对象
     * @param exceptFieldName 不需要验证的属性
     * @return 返回空Map<String, String>(not null)表示验证通过,否则会将各错误字段作为key放入Map,value为错误信息
     */
    public static Map<String, String> validateToMap(Object obj, String... exceptFieldName){
        Map<String, String> resultMap = new HashMap<String, String>();
        if(null == obj){
            throw new NullPointerException("被验证对象不能为null");
        }
        Set<ConstraintViolation<Object>> validateSet = validator.validate(obj);
        for(ConstraintViolation<Object> constraintViolation : validateSet){
            String field = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            if(!isExcept(field, exceptFieldName)){
                resultMap.put(field, message);
            }
        }
        return resultMap;
    }

    /**
     * 上送字段校验
     * @param obj
     * @throws PayException
     */
    public static void validateField(Object obj) throws PayException {
        if(obj == null){
            throw new PayException(SystemErrorCode.DATA_NOT_EXIST,new Object[]{});
        }

        Set<ConstraintViolation<Object>> validateSet = validator.validate(obj);
        TreeMap<String, String> validMap = new TreeMap<String, String>();
        for(ConstraintViolation<Object> constraintViolation : validateSet){
            String field = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            validMap.put(field, message);
        }
        if(!validMap.isEmpty()){
            throw new PayException(SystemErrorCode.DATA_NOT_EXIST,new Object[]{validMap.pollLastEntry().getValue()});
        }
    }
}
