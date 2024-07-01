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
        LogUtil.infoWithStacktrace(log, "SpringApplicationRunListener#starting");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        LogUtil.infoWithStacktrace(log, "SpringApplicationRunListener#environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        LogUtil.infoWithStacktrace(log, "SpringApplicationRunListener#contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        LogUtil.infoWithStacktrace(log, "SpringApplicationRunListener#contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        LogUtil.infoWithStacktrace(log, "SpringApplicationRunListener#started");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        LogUtil.infoWithStacktrace(log, "SpringApplicationRunListener#ready");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        LogUtil.infoWithStacktrace(log, "SpringApplicationRunListener#failed");
    }
}
