package com.zxy.admin.service;

import com.zxy.admin.entity.TbAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import commonutils.R;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxy
 * @since 2022-09-21
 */
public interface TbAdminService extends IService<TbAdmin> {

    R adminLogin(TbAdmin admin, RedisTemplate redisTemplate);
}
