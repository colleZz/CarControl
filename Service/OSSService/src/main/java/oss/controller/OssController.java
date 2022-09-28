package oss.controller;


import commonutils.R;
import commonutils.utils.RecognizeLicensePlateUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import oss.service.OssService;

import java.util.List;

@RestController
@RequestMapping("/oss/fileoss")
@CrossOrigin
//@EnableSwagger2
@Api(description="阿里云文件管理")
public class OssController {
    @Autowired
    private OssService ossService;

    @Autowired
    RedisTemplate redisTemplate;
    @PostMapping
    public R upCheckPlate(MultipartFile file) {
        //获取上传文件，MultipartFile
        //返回上传oss的url
        String url = ossService.upload(file);
        //传入之后通过车牌识别工具将所得车牌号存入redis，然后在redis中查询是否有这个车牌，如果有就是预约的用户，预约用户数据写入订单，
        try {
            List recognizeLicensePlate = RecognizeLicensePlateUtil.getRecognizeLicensePlate(url);
            //获取第一个车牌
            String plate = String.valueOf(recognizeLicensePlate.get(0));
            //通过车牌访问redis中是否存在该车主的信息（信息包含车主的身份证号，名字，微信id）
            Object mes = redisTemplate.opsForValue().get(plate);
            //如果存在则放行,不存在则提示车主须交付押金进入
            if(mes!=null){
                return R.ok().message("尊贵的车主请慢速进入停车场，并按区域寻找车位");
                //放行之后通过用户信息判断是否是租用车位用户，是则进行订单处理（按规定将信息交付Order处理，重点是记录进入时间）
            }else {
                return R.error().message("尊贵的车主请下车交付押金进入,之后扫描二维码与我们联系");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error().message("未知错误，请联系管理员解决");
    }


}
