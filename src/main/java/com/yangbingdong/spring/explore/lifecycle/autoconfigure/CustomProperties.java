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

    private boolean blockShutdown;

    private boolean gracefulDeregisterNacos;

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

    public boolean isBlockShutdown() {
        return blockShutdown;
    }

    public void setBlockShutdown(boolean blockShutdown) {
        this.blockShutdown = blockShutdown;
    }

    public boolean isGracefulDeregisterNacos() {
        return gracefulDeregisterNacos;
    }

    public void setGracefulDeregisterNacos(boolean gracefulDeregisterNacos) {
        this.gracefulDeregisterNacos = gracefulDeregisterNacos;
    }
}
