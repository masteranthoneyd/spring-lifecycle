package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
@Component
public class CustomSmartLifecycle implements
        SmartLifecycle
{

    private volatile boolean running;

    @Override
    public void start() {
        LogUtil.log("SmartLifecycle starts, traffic can be enabled", "SmartLifecycle", "start");
        running = true;
    }

    @Override
    public void stop() {
        LogUtil.log("SmartLifecycle stop, traffic can be disable", "SmartLifecycle", "stop");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
