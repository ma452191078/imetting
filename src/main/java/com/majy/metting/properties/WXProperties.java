package com.majy.metting.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by majingyuan on 2016/12/22.
 * 微信配置参数
 */

@Component
@ConfigurationProperties(prefix = "wxconf")
public class WXProperties {

    private String corpID;

    private String secret;

    private Integer expires_in;

    public String getCorpID() {
        return corpID;
    }

    public void setCorpID(String corpID) {
        this.corpID = corpID;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
