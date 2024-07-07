package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
public class CustomApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        LogUtil.log("定制 ConfigurableApplicationContext", "ApplicationContextInitializer", "initialize");
    }
}
