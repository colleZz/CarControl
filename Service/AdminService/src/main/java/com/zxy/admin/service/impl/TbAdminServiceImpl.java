package com.zxy.admin.service.impl;


import com.zxy.admin.entity.TbAdmin;
import com.zxy.admin.mapper.TbAdminMapper;
import com.zxy.admin.service.TbAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import commonutils.R;
import commonutils.utils.JWTUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxy
 * @since 2022-09-21
 */
@Service
public class TbAdminServiceImpl extends ServiceImpl<TbAdminMapper, TbAdmin> implements TbAdminService {

    @Override
    public R adminLogin(TbAdmin admin, RedisTemplate redisTemplate) {
        if(admin.getIdCard()==null){
            return R.error().message("身份证不能为空");
        }else if(admin.getPassWord()==null){
            return R.error().message("密码不能为空");
        }
        TbAdmin tbAdmin = this.getById(admin.getIdCard());
        if(tbAdmin==null){
            return R.error().message("用户不存在");
        }else if(tbAdmin.getPassWord()!=admin.getPassWord()){
            return R.error().message("密码不正确");
        }else{
            Map<String,String> map=new HashMap<>();
            map.put("name",admin.getName());
            map.put("avatar",admin.getAvatar());
            map.put("idCard",admin.getIdCard().toString());
            String token = JWTUtils.createToken(map);
            redisTemplate.opsForValue().set(admin.getName()+"_token",token);
            return R.ok().data("token",token);
        }
    }
}
