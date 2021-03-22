import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.Set;

public class PipeliningTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);//指定Redis服务Host和port
        Pipeline p = jedis.pipelined();
        p.set("fool", "bar");
        p.zadd("fooe", 1, "barowitch");  p.zadd("foo", 0, "barinsky"); p.zadd("foo", 0, "barikoviev");
        Response<String> pipeString = p.get("fool");
        Response<Set<String>> sose = p.zrange("fooe", 0, -1);
        p.sync();

        System.out.println(sose.get().size());
        System.out.println( sose.get());
    }

}
