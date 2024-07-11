package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import com.yangbingdong.spring.explore.lifecycle.bean.BizService;
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

    private BizService bizService;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        LogUtil.log("Handling the BeanFactory, such as handling ${...} in @Value placeholder, reference PropertySourcesPlaceholderConfigurer",
                "BeanFactoryPostProcessor", "postProcessBeanFactory");
    }

    /*@Autowired
    public void setBizService(BizService bizService) {
        this.bizService = bizService;
    }*/
}
