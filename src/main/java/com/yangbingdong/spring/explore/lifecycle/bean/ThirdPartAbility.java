package com.yangbingdong.spring.explore.lifecycle.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangbingdong1994@gmail.com
 */
@Component
@Slf4j
public class ThirdPartAbility {

    private BizService bizService;

    @Autowired
    public void setBizService(BizService bizService) {
        this.bizService = bizService;
    }
}
