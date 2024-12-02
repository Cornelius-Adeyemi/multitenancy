package com.adebisi.multitenantDemo;

import org.springframework.boot.SpringApplication;

public class TestServiceApplication {

    public static void  main(String... args){
        SpringApplication.from(MultitenantDemoApplication::main)
                .with(TestContainerConfig.class)
                .run(args);

    }
}
