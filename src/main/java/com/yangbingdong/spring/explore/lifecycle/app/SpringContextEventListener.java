package com.yangbingdong.spring.explore.lifecycle.app;

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
        System.out.println("\n======================> ApplicationContextEvent 事件监听: ContextStartedEvent\n");
    }

    @EventListener
    public void handleContextRefreshedEvent(ContextRefreshedEvent event) {
        System.out.println("\n======================> ApplicationContextEvent 事件监听: ContextRefreshedEvent\n");
    }

    @EventListener
    public void handleContextClosedEvent(ContextClosedEvent event) {
        System.out.println("\n======================> ApplicationContextEvent 事件监听: ContextClosedEvent\n");
    }

    @EventListener
    public void handleContextStoppedEvent(ContextStoppedEvent event) {
        System.out.println("\n======================> ApplicationContextEvent 事件监听: ContextStoppedEvent\n");
    }
}
