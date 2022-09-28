package com.zxy.admin.controller;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.netflix.client.http.HttpRequest;
import com.zxy.admin.entity.TbAdmin;
import com.zxy.admin.service.TbAdminService;
import commonutils.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import commonutils.R;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxy
 * @since 2022-09-21
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class TbAdminController {

    @Autowired
    TbAdminService adminService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("TestRedisAndJwt")
    public R Test(){
        redisTemplate.opsForValue().set("date",new TbAdmin().setIdCard(360313200111301516L).setPassWord("12345678"));
        /**
         * 1、前端登录，将用户名和密码使用jwt生成token
         * 2、以用户名为key将数据存入redis
         */
        return R.ok();
    }
    @PostMapping("/login")
    public R AdminLogin(@RequestBody TbAdmin admin){
        return adminService.adminLogin(admin,redisTemplate);
    }

    @GetMapping("test")
    public R testCon(){
        return R.ok().message("yes");
    }

    @GetMapping("getinfo")
    public R getInfo(@Param("token") String token,HttpServletRequest request){
        if("undefined".equals(token)){
            return R.error().message("请登录").data("token",50008);
        }
        if(token!=null){
            System.out.println(token);
            String header = request.getHeader(token);
            System.out.println(header);
            DecodedJWT jwt = JWTUtils.getToken(header);
            System.out.println(jwt.getClaims());
//            Object o = redisTemplate.opsForValue().get("token");
        }

        return R.ok().data("name","zxy").data("avatar","admin").data("token",token);
    }

    @PostMapping("logout")
    public R logout(HttpServletRequest request){
        String token=request.getHeader("token");
        return R.ok();
    }

}

