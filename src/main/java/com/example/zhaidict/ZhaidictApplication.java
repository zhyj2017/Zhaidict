package com.example.zhaidict;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.zhaidict.mapper")
public class ZhaidictApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhaidictApplication.class, args);
    }

}
