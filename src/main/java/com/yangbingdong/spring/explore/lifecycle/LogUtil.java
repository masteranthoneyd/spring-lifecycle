package com.yangbingdong.spring.explore.lifecycle;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
@UtilityClass
public class LogUtil {

    public static void log(String expansionPoint, String method, String message) {
        System.out.printf("-----------------------[%s]  扩展点演示 %s 开始--------------------------------------", expansionPoint, method);
        System.out.println(message);
        System.out.printf("-----------------------[%s]  扩展点演示 %s 结束--------------------------------------\n", expansionPoint, method);
    }
}
