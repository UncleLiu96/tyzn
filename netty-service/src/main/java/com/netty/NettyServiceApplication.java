package com.netty;

import com.netty.NettyService.bootstrap.NettyServerBootstrap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.Resource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class NettyServiceApplication implements CommandLineRunner {
    @Resource
    private NettyServerBootstrap nettyServerBootstrap;
    @Override
    public void run(String... args) throws Exception {
        nettyServerBootstrap.start();

    }

    public static void main(String[] args) {
        SpringApplication.run(NettyServiceApplication.class, args);
    }

}
