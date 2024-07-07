package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        LogUtil.log("对 BeanFactory 进行处理, 比如处理 @Value 中的 ${...} 占位符, 参考 PropertySourcesPlaceholderConfigurer",
                "BeanFactoryPostProcessor", "postProcessBeanFactory");
    }
}
