import redis.clients.jedis.*;
import redis.clients.jedis.util.Hashing;
import redis.clients.jedis.util.Pool;
import redis.clients.jedis.util.Sharded;

import java.util.ArrayList;
import java.util.List;

/**
 * jedis客户端实现分片
 */
public class ShardJedisPoolTest {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(500);
        config.setTestOnBorrow(true);
        List<JedisShardInfo> jdsInfoList = new ArrayList<>(6);
        jdsInfoList.add(new JedisShardInfo("127.0.0.1", 6378));
        jdsInfoList.add(new JedisShardInfo("127.0.0.1", 6379));
        ShardedJedisPool pool = new ShardedJedisPool(config, jdsInfoList, Hashing.MURMUR_HASH, Sharded.DEFAULT_KEY_TAG_PATTERN);
        ShardedJedis jds = pool.getResource();
        jds.set("user:1", "test");
        jds.set("ue8873", "test");
        jds.set("kfod:err33:1", "test");
        jds.set("helloworld:err33:1", "test");
        jds.set("maybew998:err33:1", "test");
        jds.set("k1", "test");
        jds.set("key1", "test");
        jds.set("fffff", "test");
        jds.set("bat:err33:1", "test");
        jds.set("eeeer444", "test");
        jds.hset("book:1", "name", "houlong");
        jds.close();
        pool.close();
    }
}
