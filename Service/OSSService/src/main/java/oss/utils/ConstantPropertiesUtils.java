package oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//当项目已启动，Spring接口，Spring加载之后执行接口一个方法
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    //读取配置文件内容
    @Value("${aliyun.oss.file.endpoint}")
    private  String endpoint;

    @Value("${aliyun.oss.file.keyid}")
    private  String keyid;
    @Value("${aliyun.oss.file.keysecret}")
    private  String keysecret;
    @Value("${aliyun.oss.file.bucketname}")
    private  String bucketname;

    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT=endpoint;
        ACCESS_KEY_ID=keyid;
        ACCESS_KEY_SECRET=keysecret;
        BUCKET_NAME=bucketname;
    }
}