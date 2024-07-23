package com.yangbingdong.spring.explore.lifecycle.app;

import com.alibaba.cloud.nacos.registry.NacosRegistration;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.yangbingdong.spring.explore.lifecycle.autoconfigure.CustomProperties;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.serviceregistry.AbstractAutoServiceRegistration;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
public class CustomNacosAutoServiceRegistration
        extends AbstractAutoServiceRegistration<Registration> {

    private final NacosRegistration registration;
    private final NamingService namingService;
    private final CustomProperties customProperties;

    @SneakyThrows
    public CustomNacosAutoServiceRegistration(
            NacosRegistration registration,
            CustomProperties customProperties) {
        super(null, null);
        this.registration = registration;
        this.namingService = NacosFactory.createNamingService(registration.getNacosDiscoveryProperties().getServerAddr());
        this.customProperties = customProperties;
        init();
    }

    private void init() {
        if (customProperties.isGracefulDeregisterNacos()) {
            Runtime.getRuntime().addShutdownHook(new Thread(this::gracefulShutdown));
        }
    }

    @Override
    protected Object getConfiguration() {
        return null;
    }

    @Override
    protected boolean isEnabled() {
        return true;
    }

    @Override
    protected Registration getRegistration() {
        return registration;
    }

    @Override
    protected Registration getManagementRegistration() {
        return null;
    }

    @Override
    protected void register() {
        log.info("CustomNacosAutoServiceRegistration register..............");
        String clusterName = registration.getNacosDiscoveryProperties().getClusterName();
        try {
            namingService.registerInstance("spring-lifecycle-custom", "DEFAULT_GROUP", "127.0.0.1", 8080, clusterName);
        } catch (NacosException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void deregister() {
        log.info("CustomNacosAutoServiceRegistration deregister..............");
        String clusterName = registration.getNacosDiscoveryProperties().getClusterName();
        try {
            namingService.deregisterInstance("spring-lifecycle-custom", "DEFAULT_GROUP", "127.0.0.1", 8081, clusterName);
        } catch (NacosException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected boolean shouldRegisterManagement() {
        return false;
    }

    @Override
    public void stop() {
        boolean running = this.getRunning().compareAndSet(true, false) && isEnabled();
        if (running) {
            deregister();
        } else {
            log.info("CustomNacosAutoServiceRegistration already deregistered...");
        }
    }

    @EventListener(ContextClosedEvent.class)
    public void gracefulShutdown() {
        stop();
    }
}
