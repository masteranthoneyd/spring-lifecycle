package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.logging.DeferredLogFactory;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author yangbingdong1994@gmail.com
 */
public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private final Log logger;

    public CustomEnvironmentPostProcessor(DeferredLogFactory logFactory) {
        this.logger = logFactory.getLog(CustomEnvironmentPostProcessor.class);
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        LogUtil.log("处理环境变量, 比如加载 active profiles, 参考 ConfigDataEnvironmentPostProcessor",
                "EnvironmentPostProcessor", "postProcessEnvironment");
        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 延迟日志 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
