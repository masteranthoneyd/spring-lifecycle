package com.yangbingdong.spring.explore.lifecycle.bean;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author bingdong.yang@salesforce-china.com
 */
@Component
public class CustomFactoryBean implements FactoryBean<CustomFactoryBean.CustomService> {

    @Override
    public CustomService getObject() throws Exception {
        LogUtil.log("FactoryBean create complex beans", "FactoryBean", "getObject");
        return new CustomService();
    }

    @Override
    public Class<?> getObjectType() {
        return CustomService.class;
    }

    public static class CustomService {

    }
}
