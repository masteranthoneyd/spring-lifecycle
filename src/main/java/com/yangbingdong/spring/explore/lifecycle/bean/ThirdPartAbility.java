package com.yangbingdong.spring.explore.lifecycle.bean;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
@Component
public class ThirdPartAbility implements
        InitializingBean,
        SmartInitializingSingleton,
        ApplicationContextAware {


    public ThirdPartAbility() {
        LogUtil.infoWithStacktrace(log, "ThirdPartAbility.constructor");
    }

    public void sayHello() {
        LogUtil.infoWithStacktrace(log, "Hello World!");
    }

    @PostConstruct
    public void postConstruct() {
        LogUtil.infoWithStacktrace(log, "ThirdPartAbility.@PostConstruct");
    }

    @Override
    public void afterPropertiesSet() {
        LogUtil.infoWithStacktrace(log, "ThirdPartAbility.InitializingBean.afterPropertiesSet");
    }

    @Override
    public void afterSingletonsInstantiated() {
        LogUtil.infoWithStacktrace(log, "ThirdPartAbility.SmartInitializingSingleton.afterSingletonsInstantiated");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LogUtil.infoWithStacktrace(log, "ThirdPartAbility.ApplicationContextAware.setApplicationContext");
    }
}
