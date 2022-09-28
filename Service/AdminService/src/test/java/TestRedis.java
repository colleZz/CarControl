import commonutils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRedis {
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("testREDIS")
    public R Test(){
        redisTemplate.opsForValue().get("360313200111301516token");
        return R.ok();
    }
}
