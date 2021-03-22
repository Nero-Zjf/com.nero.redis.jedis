import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class JedisClusterTest {
    public static void main(String[] args) {
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6380));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6381));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6382));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6383));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6384));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6385));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("foo", "bar");
        jc.set("book:2", "shuju");
        jc.hset("book:3", "name", "yuwen");
        String value = jc.get("foo");
    }
}
