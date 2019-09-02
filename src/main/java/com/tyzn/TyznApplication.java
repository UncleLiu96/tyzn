package com.tyzn;

import com.tyzn.NettyService.NettyServerBootstrap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TyznApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TyznApplication.class, args);

    }

    @Override
    public void run(String... args) {
        new NettyServerBootstrap().start();
    }

}
