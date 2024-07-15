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
        DisposableBean{

    private ThirdPartAbility thirdPartAbility;

    @Async
    public void sayHello() {
        log.info("Hello World!");
    }

    public BizService() {
        System.out.println("######################## BizService Constructor ########################\n");
    }

    @Autowired
    public void setThirdPartAbility(ThirdPartAbility thirdPartAbility) {
        System.out.println("######################## BizService#setThirdPartAbility Dependency Injection ########################\n");
        this.thirdPartAbility = thirdPartAbility;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LogUtil.log("Get the ApplicationContext", "ApplicationContextAware", "setApplicationContext");
    }

    @PostConstruct
    public void postConstruct() {
        LogUtil.log("bean initialization, @PostConstruct", "@PostConstruct", "@PostConstruct");
    }

    @Override
    public void afterPropertiesSet() {
        LogUtil.log("bean initialization, afterPropertiesSet", "InitializingBean", "afterPropertiesSet");
    }

    public void initMethod() {
        LogUtil.log("bean initialization, initMethod", "@Bean", "initMethod");
    }

    @Override
    public void afterSingletonsInstantiated() {
        LogUtil.log("bean initialization, afterSingletonsInstantiated", "SmartInitializingSingleton", "afterSingletonsInstantiated");
    }

    @PreDestroy
    public void preDestroy() {
        LogUtil.log("bean destruction", "@PreDestroy", "@PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        LogUtil.log("bean destruction", "DisposableBean", "destroy");
    }

    public void destroyMethod() {
        LogUtil.log("bean destruction", "@Bean", "destroyMethod");
    }
}
