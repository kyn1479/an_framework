package com.framework.demo1.controller;

import com.framework.demo1.entity.DeductReceiptRequest;
import com.framework.demo1.result.PayResult;
import com.framework.demo1.result.vo.DeductReceiptResultVo;
import com.framework.demo1.service.DeductReceiptService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 0:03
 * @Description: 单笔代扣
 */
@RestController
@RequestMapping(path="/deductReceipt")
public class DeductReceiptApiController extends BaseApiController{

    /**
     * 代扣Service
     */
    @Resource(name = "deductReceiptService")
    private DeductReceiptService deductReceiptService;

    /**
     * 单笔代扣
     * @Description 单笔代扣
     * @Params
     * @Return
     * @Exceptions
     */
    @RequestMapping("onlineReceipt")
    @ResponseBody
    public PayResult<DeductReceiptResultVo> onlineReceipt(@RequestBody DeductReceiptRequest request) {
        return deductReceiptService.onlineReceipt(request);
    }
}
