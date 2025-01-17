package com.yangbingdong.spring.explore.lifecycle.autoconfigure;

import com.yangbingdong.spring.explore.lifecycle.bean.BizService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author yangbingdong1994@gmail.com
 */
@AutoConfiguration
@EnableConfigurationProperties(CustomProperties.class)
@Import({CustomImportBeanDefinitionRegistrar.class, CustomImportSelector.class, CustomDeferredImportSelector.class})
public class ProjectConfiguration {

    private final CustomProperties customProperties;

    public ProjectConfiguration(CustomProperties customProperties) {
        System.out.println("######################## ProjectConfiguration Constructor ########################\n");
        this.customProperties = customProperties;
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BizService bizService() {
        System.out.println("######################## ProjectConfiguration.bizService() construct BizService ########################\n");
        return new BizService();
    }
}
