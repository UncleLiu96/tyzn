package com.spray;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

@EnableScheduling //定时
@SpringBootApplication(scanBasePackages = "com.spray")
@MapperScan("com.spray.project.*.mapper")
public class SprayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprayApplication.class, args);
    }

}
