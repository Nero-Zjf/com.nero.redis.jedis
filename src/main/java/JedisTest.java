import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class JedisTest {
    public static void main(String args[]) {
        //Jedis jedis = new Jedis("192.168.1.126", 6379);//指定Redis服务Host和port
        Jedis jedis = new Jedis("127.0.0.1", 6379);//指定Redis服务Host和port
        //jedis.auth("123456");//输入密码
        //jedis.set("user:1", "nero");

        //字符串
        String stringKey = "user:1";
        jedis.set(stringKey, "nero");
        System.out.println(jedis.get("stringKey")); //访问Redis服务

        jedis.append(stringKey, " hello world");
        System.out.println(jedis.get(stringKey));

        System.out.println(jedis.bitcount(stringKey));

        jedis.close(); //使用完关闭连接
    }
}
