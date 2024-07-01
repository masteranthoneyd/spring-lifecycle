package com.yangbingdong.spring.explore.lifecycle.bean;

import lombok.experimental.UtilityClass;

/**
 * @author yangbingdong1994@gmail.com
 */
@UtilityClass
public class CustomBeanUtil {

    public static boolean isBizBean(String beanName) {
        return beanName.equals("bizService") || beanName.equals("thirdPartAbility");
    }
}
