import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * 连接哨兵模式部署的redis
 */
public class JedisSentinelPoolTest {
    public static void main(String[] args) {
        Set<String> sentinels = new HashSet<>();
        sentinels.add("172.18.18.207:26379");
        sentinels.add("172.18.18.208:26379");
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setMaxTotal(20);
        JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels, config);
        Jedis jedis = pool.getResource();
        jedis.set("jedis", "jedis");
        jedis.close();
        pool.close();
    }
}
