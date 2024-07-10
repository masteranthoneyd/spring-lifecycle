package com.yangbingdong.spring.explore.lifecycle;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
@UtilityClass
public class LogUtil {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void log(String message, String expansionPoint, String method) {
        int num = counter.incrementAndGet();
        System.out.printf("\n-----------------------[%s]  扩展点 (%d) 演示 %s 开始--------------------------------------\n", expansionPoint, num, method);
        System.out.println(message);
        System.out.printf("-----------------------[%s]  扩展点 (%d) 演示 %s 结束\uD83D\uDD1A--------------------------------------\n", expansionPoint, num, method);
    }

    public static void logSpringApplicationEvent(String name) {
        System.out.printf("\n======================> 扩展点 (%d) 演示 SpringApplicationEvent 事件监听: %s\n\n", counter.incrementAndGet(), name);
    }

    public static void logApplicationContextEvent(String name) {
        System.out.printf("\n======================> 扩展点 (%d) 演示 ApplicationContextEvent 事件监听: %s\n\n", counter.incrementAndGet(), name);
    }
}
