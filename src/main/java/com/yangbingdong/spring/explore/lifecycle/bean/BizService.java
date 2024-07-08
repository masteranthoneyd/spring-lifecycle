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
        System.out.println("######################## BizService 构造器 ########################\n");
    }

    @Autowired
    public void setThirdPartAbility(ThirdPartAbility thirdPartAbility) {
        System.out.println("######################## BizService#setThirdPartAbility 依赖注入 ########################\n");
        this.thirdPartAbility = thirdPartAbility;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LogUtil.log("拿到 ApplicationContext", "ApplicationContextAware", "setApplicationContext");
    }

    @PostConstruct
    public void postConstruct() {
        LogUtil.log("bean初始化 @PostConstruct", "@PostConstruct", "@PostConstruct");
    }

    @Override
    public void afterPropertiesSet() {
        LogUtil.log("bean初始化 afterPropertiesSet", "InitializingBean", "afterPropertiesSet");
    }

    public void initMethod() {
        LogUtil.log("bean初始化 initMethod", "@Bean", "initMethod");
    }

    @Override
    public void afterSingletonsInstantiated() {
        LogUtil.log("bean初始化 afterSingletonsInstantiated", "SmartInitializingSingleton", "afterSingletonsInstantiated");
    }

    @PreDestroy
    public void close() {
        LogUtil.log("bean销毁 destroy", "@PreDestroy", "@PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        LogUtil.log("bean销毁 destroy", "DisposableBean", "destroy");
    }

    public void destroyMethod() {
        LogUtil.log("bean销毁 destroyMethod", "@Bean", "destroyMethod");
    }
}
