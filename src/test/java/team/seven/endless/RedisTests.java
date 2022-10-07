package team.seven.endless;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team.seven.endless.service.RedisService;
import team.seven.endless.service.serviceImpl.RedisServiceImpl;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/6 15:38
 */
@SpringBootTest
public class RedisTests {
    @Autowired
    RedisServiceImpl redisService;

    @Test
    public void testSet(){
        redisService.set("abc",123);
    }
}
