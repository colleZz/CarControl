package com.zxy.log.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxy.log.entity.TbLog;
import com.zxy.log.service.TbLogService;
import commonutils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxy
 * @since 2022-09-21
 */
@RestController
@RequestMapping("/log")
public class TbLogController {

    @Autowired
    TbLogService logService;

    @GetMapping("test")
    public R testCon(){
        TbLog log = logService.getOne(new QueryWrapper<>(null));
        return  R.ok().data("log",log);
    }
}

