package com.majy.metting.controller;

import com.majy.metting.service.CoreService;
import com.majy.metting.util.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by majingyuan on 2016/12/22.
 *
 */

@RestController
@RequestMapping("")
public class CoreController {


    @Autowired
    private CoreService coreService;

    //验证是否来自微信服务器的消息
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String checkSignature(@RequestParam(name = "signature", required = false) String signature,
                                 @RequestParam(name = "nonce", required = false) String nonce,
                                 @RequestParam(name = "timestamp", required = false) String timestamp,
                                 @RequestParam(name = "echostr", required = false) String echostr) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败

        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return "";
    }

    @RequestMapping(value = "/{accountid}",method = RequestMethod.POST, produces = "application/xml; charset=UTF-8")
    public  String post(@PathVariable String accountid, HttpServletRequest req){
        // 调用核心业务类接收消息、处理消息跟推送消息

        String respMessage = coreService.processRequest(req);
        return respMessage;
    }
}