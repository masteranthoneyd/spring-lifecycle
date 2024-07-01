package com.yangbingdong.spring.explore.lifecycle.autoconfigure;

import com.yangbingdong.spring.explore.lifecycle.bean.BizService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author yangbingdong1994@gmail.com
 */
@RequiredArgsConstructor
@AutoConfiguration
@EnableConfigurationProperties(CustomProperties.class)
public class ProjectConfiguration {

    private final CustomProperties customProperties;

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BizService bizService() {
        return new BizService();
    }
}
