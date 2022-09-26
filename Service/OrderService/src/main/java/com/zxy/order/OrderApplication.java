package com.zxy.order;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.zxy.order.mapper")
public class OrderApplication {
    public static void main(String []args){
        SpringApplication.run(OrderApplication.class);
    }
}
