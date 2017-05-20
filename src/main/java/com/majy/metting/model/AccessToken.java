package com.majy.metting.model;

/**
 * Created by majingyuan on 2016/12/22.
 */
public class AccessToken {
    //错误代码
    private int errCode;
    //错误信息
    private String errMsg;
    //获取到的凭证
    private String accessToken;
    //凭证有效时间，单位：秒
    private int expiresIn;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
