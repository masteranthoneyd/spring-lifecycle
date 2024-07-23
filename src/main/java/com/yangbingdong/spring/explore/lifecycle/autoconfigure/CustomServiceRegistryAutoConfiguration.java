package com.yangbingdong.spring.explore.lifecycle.autoconfigure;

import com.alibaba.cloud.nacos.ConditionalOnNacosDiscoveryEnabled;
import com.alibaba.cloud.nacos.registry.NacosRegistration;
import com.alibaba.cloud.nacos.registry.NacosServiceRegistryAutoConfiguration;
import com.yangbingdong.spring.explore.lifecycle.app.CustomNacosAutoServiceRegistration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author yangbingdong1994@gmail.com
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnNacosDiscoveryEnabled
@AutoConfigureAfter(NacosServiceRegistryAutoConfiguration.class)
public class CustomServiceRegistryAutoConfiguration {

    @Primary
    @Bean
    @ConditionalOnBean(AutoServiceRegistrationProperties.class)
    public CustomNacosAutoServiceRegistration customNacosAutoServiceRegistration(
            NacosRegistration registration,
            CustomProperties customProperties
    ) {
        return new CustomNacosAutoServiceRegistration(
                registration, customProperties);
    }
}
