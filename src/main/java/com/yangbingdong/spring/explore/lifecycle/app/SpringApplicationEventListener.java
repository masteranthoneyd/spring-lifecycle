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
            LogUtil.logSpringApplicationEvent("ApplicationStartingEvent");
        }
    }

    public static class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

        @Override
        public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
            LogUtil.logSpringApplicationEvent("ApplicationEnvironmentPreparedEvent");
        }
    }

    public static class ApplicationContextInitializedEventListener implements ApplicationListener<ApplicationContextInitializedEvent> {

        @Override
        public void onApplicationEvent(ApplicationContextInitializedEvent event) {
            LogUtil.logSpringApplicationEvent("ApplicationContextInitializedEvent");
        }
    }


    public static class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

        @Override
        public void onApplicationEvent(ApplicationPreparedEvent event) {
            LogUtil.logSpringApplicationEvent("ApplicationPreparedEvent");
        }
    }

    @EventListener
    public void handleServletWebServerInitializedEvent(ServletWebServerInitializedEvent event) {
        LogUtil.logSpringApplicationEvent("ServletWebServerInitializedEvent");
    }

    @EventListener
    public void handleApplicationStartedEvent(ApplicationStartedEvent event) {
        LogUtil.logSpringApplicationEvent("ApplicationStartedEvent");
    }

    @EventListener
    public void handleApplicationReadyEvent(ApplicationReadyEvent event) {
        LogUtil.logSpringApplicationEvent("ApplicationReadyEvent");
    }
}
