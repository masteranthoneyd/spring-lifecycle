package com.yangbingdong.spring.explore.lifecycle.app;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author yangbingdong1994@gmail.com
 */
@Component
public class CustomApplicationAndCommandRunner implements ApplicationRunner, CommandLineRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LogUtil.log("ApplicationRunner#run", "ApplicationRunner", "run");
    }

    @Override
    public void run(String... args) throws Exception {
        LogUtil.log("CommandLineRunner#run", "CommandLineRunner", "run");
    }
}
