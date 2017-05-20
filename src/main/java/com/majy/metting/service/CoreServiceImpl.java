package com.majy.metting.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by majingyuan on 2016/12/22.
 *
 */
@Service("coreService")
public class CoreServiceImpl implements CoreService {

    private static Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);

    /**
     * 处理微信发来的请求（包括事件的推送）
     *
     * @param request
     * @return
     */
    public  String processRequest(HttpServletRequest request) {

        return null;
    }
}
