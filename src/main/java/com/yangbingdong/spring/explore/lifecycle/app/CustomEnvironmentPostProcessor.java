package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author yangbingdong1994@gmail.com
 */
public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        LogUtil.log("处理环境变量, 比如加载 active profiles, 参考 ConfigDataEnvironmentPostProcessor",
                "EnvironmentPostProcessor", "postProcessEnvironment");
    }
}
