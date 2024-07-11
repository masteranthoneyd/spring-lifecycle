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
        System.out.printf("\n-----------------------[%s]  ExtensionPoint (%d) %s Begin--------------------------------------\n", expansionPoint, num, method);
        System.out.println(message);
        System.out.printf("-----------------------[%s]  ExtensionPoint (%d) %s End--------------------------------------\n", expansionPoint, num, method);
    }

    public static void logSpringApplicationEvent(String name) {
        System.out.printf("\n======================> ExtensionPoint (%d) SpringApplicationEvent Listen: %s\n\n", counter.incrementAndGet(), name);
    }

    public static void logApplicationContextEvent(String name) {
        System.out.printf("\n======================> ExtensionPoint (%d) ApplicationContextEvent Listen: %s\n\n", counter.incrementAndGet(), name);
    }
}
