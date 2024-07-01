package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
@Component
public class SpringContextEventListener {

    @EventListener
    public void handleContextStartedEvent(ContextStartedEvent event) {
        LogUtil.infoWithStacktrace(log, "[ContextStartedEvent]...");
    }

    @EventListener
    public void handleContextRefreshedEvent(ContextRefreshedEvent event) {
        LogUtil.infoWithStacktrace(log, "[ContextRefreshedEvent]...");
    }

    @EventListener
    public void handleContextClosedEvent(ContextClosedEvent event) {
        LogUtil.infoWithStacktrace(log, "[ContextClosedEvent]...");
    }

    @EventListener
    public void handleContextStoppedEvent(ContextStoppedEvent event) {
        LogUtil.infoWithStacktrace(log, "[ContextStoppedEvent]...");
    }
}
