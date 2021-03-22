import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class TransactionTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);//指定Redis服务Host和port
        jedis.watch ("k1", "k2");
        Transaction t = jedis.multi();
        t.set("foo", "ccc");
        Response<String> result1 = t.get("foo");
        t.exec();
        System.out.println(result1.get());
    }
}
