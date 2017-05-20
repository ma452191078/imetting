package com.majy.metting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by majingyuan on 2017/5/18.
 *
 */
@RestController
public class indexController {

    @RequestMapping("/")
    public String index(){
        return "Hello World";
    }

}
