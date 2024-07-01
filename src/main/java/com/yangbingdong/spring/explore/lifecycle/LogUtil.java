package com.yangbingdong.spring.explore.lifecycle;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
@UtilityClass
public class LogUtil {

    public static void infoWithStacktrace(Logger log, String msg) {
        log.info(msg, log.isTraceEnabled() ? new TestException() : null);
    }
}
