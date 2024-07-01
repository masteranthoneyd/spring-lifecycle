package com.yangbingdong.spring.explore.lifecycle.bean;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
public class BizService implements
        InitializingBean,
        SmartInitializingSingleton,
        ApplicationContextAware,
        DisposableBean {

    private ThirdPartAbility thirdPartAbility;

    @Async
    public void sayHello() {
        log.info("Hello World!");
    }

    public BizService() {
        LogUtil.infoWithStacktrace(log, "BizService#constructor");
    }

    @Autowired
    public void setThirdPartAbility(ThirdPartAbility thirdPartAbility) {
        LogUtil.infoWithStacktrace(log, "BizService.@Autowired#setThirdPartAbility");
        this.thirdPartAbility = thirdPartAbility;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LogUtil.infoWithStacktrace(log, "BizService.ApplicationContextAware#setApplicationContext");
    }

    @PostConstruct
    public void postConstruct() {
        LogUtil.infoWithStacktrace(log, "BizService#@PostConstruct");
    }

    @Override
    public void afterPropertiesSet() {
        LogUtil.infoWithStacktrace(log, "BizService.InitializingBean#afterPropertiesSet");
    }

    public void initMethod() {
        LogUtil.infoWithStacktrace(log, "BizService#initMethod");
    }

    @Override
    public void afterSingletonsInstantiated() {
        LogUtil.infoWithStacktrace(log, "BizService.SmartInitializingSingleton#afterSingletonsInstantiated");
    }

    @PreDestroy
    public void close() {
        LogUtil.infoWithStacktrace(log, "BizService.@PreDestroy#close");
    }

    @Override
    public void destroy() throws Exception {
        LogUtil.infoWithStacktrace(log, "BizService.DisposableBean#destroy");
    }

    public void destroyMethod() {
        LogUtil.infoWithStacktrace(log, "BizService#destroyMethod");
    }
}
