package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
@Component
public class SpringApplicationEventListener {


    public static class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

        @Override
        public void onApplicationEvent(ApplicationStartingEvent event) {
            // log component is not loaded
            System.out.println("[ApplicationStartingEventListener.ApplicationStartingEvent]...");
        }
    }

    @EventListener
    public void handleApplicationStartingEvent(ApplicationStartingEvent event) {
        System.out.println("[ApplicationStartingEvent]...");
    }

    public static class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

        @Override
        public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
            // log component is not loaded
            System.out.println("[ApplicationEnvironmentPreparedEventListener.ApplicationEnvironmentPreparedEvent]...");
        }
    }

    @EventListener
    public void handleApplicationEnvironmentPreparedEvent(ApplicationEnvironmentPreparedEvent event) {
        LogUtil.infoWithStacktrace(log, "[ApplicationEnvironmentPreparedEvent]...");
    }

    public static class ApplicationContextInitializedEventListener implements ApplicationListener<ApplicationContextInitializedEvent> {

        @Override
        public void onApplicationEvent(ApplicationContextInitializedEvent event) {
            LogUtil.infoWithStacktrace(log, "[ApplicationEnvironmentPreparedEventListener.ApplicationContextInitializedEvent]...");
        }
    }

    @EventListener
    public void handleApplicationContextInitializedEvent(ApplicationContextInitializedEvent event) {
        LogUtil.infoWithStacktrace(log, "[ApplicationContextInitializedEvent]...");
    }

    public static class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

        @Override
        public void onApplicationEvent(ApplicationPreparedEvent event) {
            LogUtil.infoWithStacktrace(log, "[ApplicationEnvironmentPreparedEventListener.ApplicationPreparedEvent]...");
        }
    }

    @EventListener
    public void handleApplicationPreparedEvent(ApplicationPreparedEvent event) {
        LogUtil.infoWithStacktrace(log, "[ApplicationPreparedEvent]...");
    }

    @EventListener
    public void handleServletWebServerInitializedEvent(ServletWebServerInitializedEvent event) {
        LogUtil.infoWithStacktrace(log, "[ServletWebServerInitializedEvent]...");
    }

    @EventListener
    public void handleApplicationStartedEvent(ApplicationStartedEvent event) {
        LogUtil.infoWithStacktrace(log, "[ApplicationStartedEvent]...");
    }

    @EventListener
    public void handleApplicationReadyEvent(ApplicationReadyEvent event) {
        LogUtil.infoWithStacktrace(log, "[ApplicationReadyEvent]...");
    }
}
