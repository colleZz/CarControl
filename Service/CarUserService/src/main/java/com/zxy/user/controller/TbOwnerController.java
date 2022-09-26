package com.zxy.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxy.user.entity.TbOwner;
import com.zxy.user.service.TbOwnerService;
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
@RequestMapping("/user/owner")
public class TbOwnerController {

    @Autowired
    TbOwnerService ownerService;

    @GetMapping("test")
    public R TestCon(){
        List<TbOwner> list = ownerService.list(new QueryWrapper<>(null));
        return R.ok().data("owners",list);
    }
}

