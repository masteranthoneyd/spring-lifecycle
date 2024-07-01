package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author yangbingdong1994@gmail.com
 */
@Slf4j
@Component
public class CustomApplicationAndCommandRunner implements ApplicationRunner, CommandLineRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LogUtil.infoWithStacktrace(log, "CustomApplicationAndCommandRunner.ApplicationRunner#run");
    }

    @Override
    public void run(String... args) throws Exception {
        LogUtil.infoWithStacktrace(log, "CustomApplicationAndCommandRunner.CommandLineRunner#run");
    }
}
