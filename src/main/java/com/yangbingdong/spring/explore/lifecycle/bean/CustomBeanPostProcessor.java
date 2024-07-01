package com.yangbingdong.spring.explore.lifecycle.bean;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

import static com.yangbingdong.spring.explore.lifecycle.bean.CustomBeanUtil.isBizBean;

/**
 * @author yangbingdong1994@gmail.com
 */
@Configuration
@Slf4j
public class CustomBeanPostProcessor implements
        BeanPostProcessor,
        PriorityOrdered {

    private BizService bizService;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (isBizBean(beanName)) {
            LogUtil.infoWithStacktrace(log, "CustomBeanPostProcessor.MergedBeanDefinitionPostProcessor#postProcessBeforeInitialization." + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (isBizBean(beanName)) {
            LogUtil.infoWithStacktrace(log, "CustomBeanPostProcessor.MergedBeanDefinitionPostProcessor#postProcessAfterInitialization." + beanName);
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

/*    @Autowired
    public void setBizService(BizService bizService) {
        this.bizService = bizService;
    }*/

}
