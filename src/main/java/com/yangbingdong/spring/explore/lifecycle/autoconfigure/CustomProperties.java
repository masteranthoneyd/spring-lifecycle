package com.yangbingdong.spring.explore.lifecycle.autoconfigure;

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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("######################## CustomProperties#setName ########################\n");
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
