import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String args[]) {
        Jedis jedis = new Jedis("192.168.1.126", 6379);//指定Redis服务Host和port
        jedis.auth("123456");//输入密码
        jedis.set("user:1", "nero");
        String value = jedis.get("user:1"); //访问Redis服务
        System.out.println(value);
        jedis.close(); //使用完关闭连接
    }
}
