package com.yangbingdong.spring.explore.lifecycle.bean;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
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
        InstantiationAwareBeanPostProcessor,
        PriorityOrdered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (isBizBean(beanName)) {
            LogUtil.log("Bean初始化之前", "BeanPostProcessor", "postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (isBizBean(beanName)) {
            LogUtil.log("Bean初始化之后", "BeanPostProcessor", "postProcessAfterInitialization");
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (isBizBean(beanName)) {
            LogUtil.log("Bean构造之前", "InstantiationAwareBeanPostProcessor", "postProcessBeforeInstantiation");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (isBizBean(beanName)) {
            LogUtil.log("Bean构造之后", "InstantiationAwareBeanPostProcessor", "postProcessAfterInstantiation");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (isBizBean(beanName)) {
            LogUtil.log("Bean依赖注入", "InstantiationAwareBeanPostProcessor", "postProcessProperties");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }
}
