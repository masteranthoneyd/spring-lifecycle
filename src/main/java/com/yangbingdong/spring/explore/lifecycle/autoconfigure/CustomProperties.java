package com.yangbingdong.spring.explore.lifecycle.autoconfigure;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
@ConfigurationProperties(prefix = "lifecycle.custom")
public class CustomProperties {

    private String name;

    private Integer age;

    public CustomProperties() {
        LogUtil.infoWithStacktrace(log, "CustomProperties.constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        LogUtil.infoWithStacktrace(log, "CustomProperties.setName");
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        LogUtil.infoWithStacktrace(log, "CustomProperties.setAge");
        this.age = age;
    }
}
