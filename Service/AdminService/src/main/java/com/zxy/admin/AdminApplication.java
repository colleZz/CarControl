package com.zxy.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.zxy")
@MapperScan("com.zxy.admin.mapper")
@EnableSwagger2
public class AdminApplication {
    public static void main(String []args){
        SpringApplication.run(AdminApplication.class);
    }
}
