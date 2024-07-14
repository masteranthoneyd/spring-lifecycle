package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * @author yangbingdong1994@gmail.com
 *
 * 注册时机: CustomApplicationContextInitializer#initialize(org.springframework.context.ConfigurableApplicationContext)
 * 或者直接贴 @Component 区别是上面的方式配置, 可在 ConfigurationClassPostProcessor 之前执行, @Component 本身依赖于 ConfigurationClassPostProcessor.
 */
//@Component
@Slf4j
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        LogUtil.log("You can register beans dynamically", "BeanDefinitionRegistryPostProcessor", "postProcessBeanDefinitionRegistry");
    }

    @Override
    public int getOrder() {
        return PriorityOrdered.HIGHEST_PRECEDENCE;
    }
}
