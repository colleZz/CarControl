package com.zxy.order.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxy.order.client.DemoClient;
import com.zxy.order.entity.TbOrder;
import com.zxy.order.service.TbOrderService;
import commonutils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxy
 * @since 2022-09-21
 */
@RestController
@RequestMapping("/order")
public class TbOrderController {
    @Autowired
    TbOrderService orderService;
    @Autowired
    DemoClient demoClient;

    @GetMapping("test")
    public R TestCon(){
        List<TbOrder> list = orderService.list(new QueryWrapper<>(null));
        return  R.ok().data("orders",list);
    }

    @GetMapping("TestFei")
    public R TestFei(){
        return demoClient.TestFei();
    }

}

