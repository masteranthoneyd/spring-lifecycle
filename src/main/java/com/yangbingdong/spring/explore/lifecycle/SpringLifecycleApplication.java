package com.yangbingdong.spring.explore.lifecycle;

import com.yangbingdong.spring.explore.lifecycle.bean.BizService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync(proxyTargetClass = true)
@SpringBootApplication
public class SpringLifecycleApplication {

    public static void main(String[] args) {
        SpringApplication springApplication =  new SpringApplicationBuilder(SpringLifecycleApplication.class).build();
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println("SpringApplication.run finished");
        ((BizService) context.getBean("bizService")).sayHello();
//        context.close();
    }
}
