package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import com.yangbingdong.spring.explore.lifecycle.autoconfigure.CustomProperties;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
@Component
public class CustomSmartLifecycle implements
        SmartLifecycle {

    private volatile boolean running;

    private final CustomProperties customProperties;

    public CustomSmartLifecycle(CustomProperties customProperties) {
        this.customProperties = customProperties;
    }

    @Override
    public void start() {
        LogUtil.log("SmartLifecycle starts, traffic can be enabled", "SmartLifecycle", "start");
        running = true;
    }

    @SneakyThrows
    @Override
    public void stop() {
        if (customProperties.isBlockShutdown()) {
            log.warn("Blocking shutdown...");
            Thread.sleep(Duration.of(60, ChronoUnit.SECONDS));
        }
        LogUtil.log("SmartLifecycle stop, traffic can be disable", "SmartLifecycle", "stop");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
