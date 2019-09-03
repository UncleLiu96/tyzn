package com.tyzn;

import com.tyzn.NettyService.bootstrap.NettyServerBootstrap;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;


@SpringBootApplication(scanBasePackages = "com")
@MapperScan("com.tyzn.project.*.mapper")
public class TyznApplication  implements CommandLineRunner {
    @Resource
    private NettyServerBootstrap nettyServerBootstrap;
    @Override
    public void run(String... args) throws Exception {
        nettyServerBootstrap.start();
    }

    public static void main(String[] args) {
        SpringApplication.run(TyznApplication.class, args);
    }

}
