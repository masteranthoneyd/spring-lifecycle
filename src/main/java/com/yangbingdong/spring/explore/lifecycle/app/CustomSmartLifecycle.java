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
//        , Lifecycle
{

    private volatile boolean running;

    @Override
    public void start() {
        LogUtil.infoWithStacktrace(log, "CustomSmartLifecycle.SmartLifecycle#start");
        running = true;
    }

    @Override
    public void stop() {
        LogUtil.infoWithStacktrace(log, "CustomSmartLifecycle.SmartLifecycle#stop");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
