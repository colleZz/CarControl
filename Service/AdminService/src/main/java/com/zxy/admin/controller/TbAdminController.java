package com.zxy.admin.controller;


import com.zxy.admin.entity.TbAdmin;
import com.zxy.admin.service.TbAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import commonutils.R;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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

    @PostMapping("/login")
    public R AdminLogin(@RequestBody TbAdmin admin){
        if(admin.getIdCard()==null){
            return R.error().message("用户名不能为空");
        }else if(admin.getPassWord() == null){
            return R.error().message("密码不能为空");
        }
        TbAdmin tbAdmin = adminService.getById(admin.getIdCard());
        if(tbAdmin==null){
            return R.error().message("用户名不存在");
        }else {
            if(tbAdmin.getPassWord().equals(admin.getPassWord())){
                return R.ok().message("登录成功");
            }else {
                return R.error().message("密码错误").data("token",200);
            }
        }
    }

    @GetMapping("test")
    public R testCon(){
        return R.ok().message("yes");
    }

    @GetMapping("getinfo")
    public R getInfo(String token){
        if("undefined".equals(token)){
            return R.error().message("请登录").data("token",50008);
        }
        return R.ok().data("name","zxy").data("avatar","zxy").data("token",200);
    }

    @PostMapping("logout")
    public R logout(){
        return R.ok().message("退出").data("token",50008);
    }
}

