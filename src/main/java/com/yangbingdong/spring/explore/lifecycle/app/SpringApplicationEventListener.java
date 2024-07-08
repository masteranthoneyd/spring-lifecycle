package com.yangbingdong.spring.explore.lifecycle.app;

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
            System.out.println("\n======================> SpringApplicationEvent 事件监听: ApplicationStartingEvent\n");
        }
    }

    public static class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

        @Override
        public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
            System.out.println("\n======================> SpringApplicationEvent 事件监听: ApplicationEnvironmentPreparedEvent\n");
        }
    }

    public static class ApplicationContextInitializedEventListener implements ApplicationListener<ApplicationContextInitializedEvent> {

        @Override
        public void onApplicationEvent(ApplicationContextInitializedEvent event) {
            System.out.println("\n======================> SpringApplicationEvent 事件监听: ApplicationContextInitializedEvent\n");
        }
    }


    public static class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

        @Override
        public void onApplicationEvent(ApplicationPreparedEvent event) {
            System.out.println("\n======================> SpringApplicationEvent 事件监听: ApplicationPreparedEvent\n");
        }
    }

    @EventListener
    public void handleServletWebServerInitializedEvent(ServletWebServerInitializedEvent event) {
        System.out.println("\n======================> ApplicationEvent 事件监听: ServletWebServerInitializedEvent\n");
    }

    @EventListener
    public void handleApplicationStartedEvent(ApplicationStartedEvent event) {
        System.out.println("\n======================> SpringApplicationEvent 事件监听: ApplicationStartedEvent\n");
    }

    @EventListener
    public void handleApplicationReadyEvent(ApplicationReadyEvent event) {
        System.out.println("\n======================> SpringApplicationEvent 事件监听: ApplicationReadyEvent\n");
    }
}
