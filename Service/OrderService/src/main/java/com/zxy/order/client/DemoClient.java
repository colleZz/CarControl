package com.zxy.order.client;

import commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Log-Service")
public interface DemoClient {
    @GetMapping("/log/test")
    R TestFei();
}
