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
        LogUtil.log("Application starting", "SpringApplicationRunListener", "starting");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        LogUtil.log("Application environmentPrepared", "SpringApplicationRunListener", "environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        LogUtil.log("ApplicationContext contextPrepared", "SpringApplicationRunListener", "contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        LogUtil.log("ApplicationContext contextLoaded", "SpringApplicationRunListener", "contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        LogUtil.log("Application started", "SpringApplicationRunListener", "started");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        LogUtil.log("Application ready", "SpringApplicationRunListener", "ready");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        LogUtil.log("Application failed", "SpringApplicationRunListener", "failed");
    }
}
