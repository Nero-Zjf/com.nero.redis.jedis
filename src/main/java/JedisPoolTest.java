import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 使用jedis连接池
 */
public class JedisPoolTest {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool pool = new JedisPool(config, "192.168.1.126", 6379, 2000, "123456");
        Jedis jedis = pool.getResource();
        jedis.set("user:1", "nero");
        String value = jedis.get("user:1"); //访问Redis服务
        System.out.println(value);

        jedis.close();
        pool.close();
    }
}
