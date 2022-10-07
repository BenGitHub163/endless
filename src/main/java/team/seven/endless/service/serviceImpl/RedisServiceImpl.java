package team.seven.endless.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.seven.endless.service.RedisService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis操作实现类
 * Created by macro on 2020/3/3.
 */
@Service
@Transactional
public class RedisServiceImpl implements RedisService {
    private static final Logger log = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 新增一个字符串类型的值，key是键，value是值。
     *
     * @param key   键
     * @param value 值
     * @param time  过期时间
     */
    @Override
    public Boolean set(String key, Object value, long time) {
        try{
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    /**
     * @param key   键
     * @param value 值
     */
    @Override
    public Boolean set(String key, Object value) {
        try{
            redisTemplate.opsForValue().set(key, value);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    /**
     * 获取key键对应的值。
     *
     * @param key 键
     * @return {@link Object}
     */
    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除key键对应的值。
     *
     * @param key 键
     * @return {@link Boolean}
     */
    @Override
    public Boolean del(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Long del(List<String> keys) {
        return redisTemplate.delete(keys);
    }

    /**
     * 判断key是否到期
     *
     * @param key  键
     * @param time 当前时间
     * @return {@link Boolean}
     */
    @Override
    public Boolean expire(String key, long time) {
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 获取过期时间
     *
     * @param key 键
     * @return {@link Long}
     */
    @Override
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断是否有该键
     *
     * @param key 键
     * @return {@link Boolean}
     */
    @Override
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 以增量的方式将long值存储在变量中。
     *
     * @param key   关键
     * @param delta δ
     * @return {@link Long}
     */
    @Override
    public Long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 以负增量的方式将long值存储在变量中。
     *
     * @param key   关键
     * @param delta δ
     * @return {@link Long}
     */
    @Override
    public Long decr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    @Override
    public Object hGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    @Override
    public Boolean hSet(String key, String hashKey, Object value, long time) {
        redisTemplate.opsForHash().put(key, hashKey, value);
        return expire(key, time);
    }

    @Override
    public Boolean hSet(String key, String hashKey, Object value) {
        try{
            redisTemplate.opsForHash().put(key, hashKey, value);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public Map<Object, Object> hGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public Boolean hSetAll(String key, Map<String, Object> map, long time) {
        redisTemplate.opsForHash().putAll(key, map);
        return expire(key, time);
    }

    @Override
    public Boolean hSetAll(String key, Map<String, ?> map) {
        try{
            redisTemplate.opsForHash().putAll(key, map);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean hDel(String key, Object... hashKey) {
        try{
            redisTemplate.opsForHash().delete(key, hashKey);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean hHasKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    @Override
    public Long hIncr(String key, String hashKey, Long delta) {
        return redisTemplate.opsForHash().increment(key, hashKey, delta);
    }

    @Override
    public Long hDecr(String key, String hashKey, Long delta) {
        return redisTemplate.opsForHash().increment(key, hashKey, -delta);
    }

    @Override
    public Set<Object> sMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    @Override
    public Long sAdd(String key, Object... values) {
        return redisTemplate.opsForSet().add(key, values);
    }

    @Override
    public Long sAdd(String key, long time, Object... values) {
        Long count = redisTemplate.opsForSet().add(key, values);
        expire(key, time);
        return count;
    }

    @Override
    public Boolean sIsMember(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    @Override
    public Long sSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    @Override
    public Long sRemove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    @Override
    public List<Object> lRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    @Override
    public Long lSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    @Override
    public Object lIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    @Override
    public Long lPush(String key, Object value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    @Override
    public Long lPush(String key, Object value, long time) {
        Long index = redisTemplate.opsForList().rightPush(key, value);
        expire(key, time);
        return index;
    }

    @Override
    public Long lPushAll(String key, Object... values) {
        return redisTemplate.opsForList().rightPushAll(key, values);
    }

    @Override
    public Long lPushAll(String key, Long time, Object... values) {
        Long count = redisTemplate.opsForList().rightPushAll(key, values);
        expire(key, time);
        return count;
    }

    @Override
    public Long lRemove(String key, long count, Object value) {
        return redisTemplate.opsForList().remove(key, count, value);
    }
}
