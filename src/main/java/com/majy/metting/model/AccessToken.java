package com.majy.metting.model;

import lombok.Data;

import javax.persistence.Entity;

/**
 *
 * Created by majingyuan on 2016/12/22.
 */

@Entity
@Data
public class AccessToken {
    //错误代码
    private int errCode;
    //错误信息
    private String errMsg;
    //获取到的凭证
    private String accessToken;
    //凭证有效时间，单位：秒
    private int expiresIn;

    public AccessToken() {

    }
}
