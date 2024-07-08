package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
public class CustomSpringApplicationRunListener implements SpringApplicationRunListener {

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        LogUtil.log("Application 启动中", "SpringApplicationRunListener", "starting");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        LogUtil.log("Application 环境变量已准备好", "SpringApplicationRunListener", "environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        LogUtil.log("ApplicationContext 已准备好", "SpringApplicationRunListener", "contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        LogUtil.log("ApplicationContext 已加载", "SpringApplicationRunListener", "contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        LogUtil.log("Application 已启动", "SpringApplicationRunListener", "started");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        LogUtil.log("Application 已就绪", "SpringApplicationRunListener", "ready");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        LogUtil.log("Application 启动失败", "SpringApplicationRunListener", "failed");
    }
}
